package com.keyrene.service;

import com.keyrene.User;
import com.keyrene.UserRepository;
import com.keyrene.enums.ResultEnum;
import com.keyrene.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/31 0031.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void getAge(Integer id)throws Exception{
        User user = repository.findOne(id);
        Integer age = Integer.valueOf(user.getBirthday());
        if (age<10){
            throw new UserException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age>10&&age<16){
            throw new UserException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    public User getUser(Integer id){
        return repository.findOne(id);
    }
}
