package com.inrdev.Controller;


import com.inrdev.Entity.User;
import com.inrdev.Service.IUService;
import com.inrdev.Utils.ResultModel;
import com.inrdev.Utils.ResultModelTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    IUService iuService;

    //获取全部的用户数据
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResultModel getAllUser(){
        List<User> users = iuService.getAllUser();
        Map<String,List<User>> userMap = new HashMap<>();
        if (users != null){
            userMap.put("users",users);
        }
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(0);
        resultModel.setData(userMap);
        return ResultModelTool.handleResultModel(resultModel);
    }
    //添加一个用户信息
    @PostMapping(value = "/add")
    public ResultModel addUser(User user){
        int errorCode = iuService.addUser(user);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(errorCode);
        resultModel.setData(user);
        return ResultModelTool.handleResultModel(resultModel);
    }
    //修改一个数据
    @PutMapping(value = "/update")
    public ResultModel updateUser(User user){
        int errorCode = iuService.updateUser((user));
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(errorCode);
        resultModel.setData(user);
        return ResultModelTool.handleResultModel(resultModel);
    }
    //根据id查取指定数据
    @GetMapping(value = "/findbyid/{id}")
    public ResultModel findById(@PathVariable(value = "id") Long id){
        User user = iuService.queryUser(id);
        ResultModel resultModel = new ResultModel();
       if (user != null){
           resultModel.setData(user);
           resultModel.setCode(0);
           return ResultModelTool.handleResultModel(resultModel);
       }else{
           resultModel.setCode(-1);
           resultModel.setMsg("请求失败");
           return ResultModelTool.handleResultModel(resultModel);
       }
    }

    //根据id删除指定数据
    @DeleteMapping(value = "/delete/{id}")
    public ResultModel deleteUser(@PathVariable(value = "id") Long id){
        int errorCode = iuService.deleteUser(id);
        ResultModel resultModel = new ResultModel();
        List<User> users = iuService.getAllUser();
        Map<String,List<User>> map = new HashMap<>();
        if (users != null){
            map.put("users",users);
        }
        resultModel.setCode(errorCode);
        resultModel.setData(map);
        return ResultModelTool.handleResultModel(resultModel);
    }
    //根据条件查询
    @RequestMapping(value = "/getcon")
    public ResultModel getConditionUser(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password){
        List<User> list = iuService.findByDynamicCases(username,password);
        ResultModel resultModel = new ResultModel();
        Map<String,List<User>> map = new HashMap<>();
        if(list != null){
            map.put("users",list);
        }
        resultModel.setCode(0);
        resultModel.setData(map);
        return ResultModelTool.handleResultModel(resultModel);
    }
}

