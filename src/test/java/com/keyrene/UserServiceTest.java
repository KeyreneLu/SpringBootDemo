package com.keyrene;

import com.keyrene.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/5/31 0031.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findUserOneTest(){
       User user = userService.getUser(18);
        Assert.assertEquals(new Integer(15),Integer.valueOf(user.getBirthday()));
    }
}
