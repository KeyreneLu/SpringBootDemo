package com.keyrene;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 可以由自己来扩展
 * Created by Administrator on 2017/5/26 0026.
 */
public interface  UserRepository extends JpaRepository<User,Integer> {

    //通过用户名查询数据
    public User findUserByUsername(String username);
}
