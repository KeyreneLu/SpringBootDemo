package com.keyrene.controller;

import com.keyrene.User;
import com.keyrene.UserRepository;
import com.keyrene.domain.Result;
import com.keyrene.service.UserService;
import com.keyrene.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2017/5/26 0026.
 */
@RestController
@RequestMapping(value = "/account")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService service;
    /**
     * 查询用户列表接口
     * @return 查询结果
     */
    @GetMapping(value = "/list")
    public Result findUser(){
        Result<List<User>> result = new Result<>();
        List<User> list = repository.findAll();
        if (list!= null && list.size() != 0){
            result.setCode("200");
            result.setMsg("查询成功");
            result.setData(list);
        }else {
            result.setCode("101");
            result.setMsg("没有查找到数据");
            result.setData(list);
        }
        return result;
    }

    @PostMapping("/add")
//    public Result addUser(@RequestParam("username") String username,@RequestParam("phone") String phone,
//                          @RequestParam("address") String address, @RequestParam("birthday") String birthday,
//                          @RequestParam("sex") String sex){
    public Result addUser(@Valid User user2, BindingResult bindingResult){
        User user = new User();
        if (bindingResult.hasErrors()){
            return null;
//            return ResultUtil.fail("101",bindingResult.getFieldError().getDefaultMessage()+"");
        }
        user.setId(0);
        user.setPhone(user2.getPhone());
        user.setAddress(user2.getAddress());
        user.setBirthday(user2.getBirthday());
        user.setUsername(user2.getUsername());
        user.setSex(user2.getSex());

        User user1 = repository.save(user);


        if (user1 != null){
            return ResultUtil.success(user1);
        }else {
            return ResultUtil.fail("101","数据插入失败，请重试");
        }
    }

    @GetMapping("/user/{id}")
    public Result findUserById(@PathVariable("id") Integer id ){
        User user = repository.findOne(id);
        Result<User> result = new Result<>();
        if (user != null){
            result.setCode("200");
            result.setMsg("查询成功");
            result.setData(user);
        }else {
            result.setCode("101");
            result.setMsg("查询失败");
            result.setData(user);
        }
        return result;
    }

    @PostMapping("/update")
    public Result updateUserInfo(@RequestParam("id") Integer id,@RequestParam("username") String username
                                ,@RequestParam("phone") String phone, @RequestParam("address") String address
                                , @RequestParam("birthday") String birthday, @RequestParam("sex") String sex){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPhone(phone);
        user.setAddress(address);
        user.setBirthday(birthday);
        user.setSex(sex);

        Result<User> result = new Result<>();
        User user1 = repository.save(user);
        if (user1 != null){
            result.setCode("200");
            result.setMsg("更新成功");
            result.setData(user1);
        }else {
            result.setCode("101");
            result.setMsg("更新失败");
            result.setData(user1);
        }

        return result;
    }

    @GetMapping("/delete/{id}")
    public Result deleteUserById(@PathVariable("id") Integer id){
        User user = repository.findOne(id);
        Result<String> result = new Result<>();
        if (user == null){
            result.setCode("101");
            result.setMsg("无效Id值!");
            result.setData("");
        }else {
            repository.delete(id);
            if (repository.findOne(id) != null){
                result.setCode("200");
                result.setMsg("删除成功");
                result.setData("");
            }else {
                result.setCode("102");
                result.setMsg("删除失败");
                result.setData("");
            }
        }
        return result;
    }

    @PostMapping("/find/username")
    public Result findUserByUsername(@RequestParam("name") String username){
        User user = repository.findUserByUsername(username);
        Result<User> result = new Result<>();
        if (user != null){
            result.setCode("200");
            result.setMsg("查询数据成功");
            result.setData(user);
        }else {
            result.setCode("101");
            result.setMsg("查询数据失败");
            result.setData(user);
        }
        return result;
    }

    @RequestMapping(value = "getAge/{id}")
    public void getAge(@PathVariable("id") Integer id)throws Exception{
        service.getAge(id);
    }
}
