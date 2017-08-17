package com.keyrene.controller;

import com.keyrene.PersonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by Administrator on 2017/5/26 0026.
 */
@Controller
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Autowired
    private PersonProperties personProperties;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String firstHello(Model model){
        model.addAttribute("cupSize","Hello SpringBoot FreeMarker");
        model.addAttribute("time",new Date());
        return "hello";
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String findUser(){

        return personProperties.getName();
    }
}
