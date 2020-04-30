package com.inrdev.Service;

import com.inrdev.Entity.User;
import com.inrdev.Repository.JpaUserRepository;
import com.inrdev.Utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.*;
import java.util.List;

@Service
public class UserService implements IUService {

    @Autowired
    JpaUserRepository jpaUserRepository;

    @Override
    public List<User> getAllUser() {
        List<User> users = jpaUserRepository.findAll();
        System.out.println(users.toString());
        return users;
    }

    @Override
    public int addUser(User user) {
        User save = jpaUserRepository.save(user);
        if(save != null && save.getUname().equals(user.getUname())){
            System.out.println("save seccesss");
            return ErrorCode.ADDSUCCESS;
        }else {
            System.out.println("save failure");
            return ErrorCode.ADDFAIL;
        }
    }

    @Override
    public int deleteUser(Long id) {
        if (jpaUserRepository.existsById(id)){
            jpaUserRepository.deleteById(id);
            System.out.println("删除成功");
            return ErrorCode.DELETESUCCESS;
        }else{
            System.out.println("删除失败");
            return ErrorCode.DELETEFAIL;
        }
    }

    @Override
    public int updateUser(User user) {
        if (jpaUserRepository.existsById(user.getUid())){
            jpaUserRepository.save(user);
            System.out.println("更新成功");
            return ErrorCode.UPDATESUCCESS;
        }else{
            System.out.println("更新失败");
            return ErrorCode.UPDATEFAIL;
        }
    }

    @Override
    public User queryUser(long id) {
        User user = null;
        if(jpaUserRepository.existsById(id)) {
            user = jpaUserRepository.findById(id).get();
            return user;
        }
        else {
            return null;
        }
    }

    @Override
    public List<User> findByDynamicCases(String uname, String pword) {
        List<User> all = jpaUserRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate1, predicate2, predicate3;

                Path username = root.get("username");
                Path password = root.get("password");

                predicate1 = criteriaBuilder.equal(username, uname);
                predicate2 = criteriaBuilder.equal(password, pword);
                criteriaQuery.where(predicate1, predicate2);
                return null;
            }
        });
        return all;
    }
}
