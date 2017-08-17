package com.keyrene.controller;

import com.keyrene.User;
import com.keyrene.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/30 0030.
 */
@Controller
@RequestMapping(value = "/user")
public class UserHtmlController {

    @Autowired
    private UserRepository repository;

    /**
     * 查询用户列表接口
     * @return 查询结果
     */
    @GetMapping(value = "/list.do")
    public String findUsers(Map<String,Object> map){

        List<User> list = repository.findAll();
//        model.addAttribute("users",list.size()+"");
        map.put("users",list);
        return "user-list";
    }
}
