package com.controller;

import com.sun.org.apache.bcel.internal.generic.IFNULL;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public class Test {

    private Logger logger = Logger.getLogger(Test.class);

    @RequestMapping("/Test")
    public String Test(){
        logger.info("12345");
        System.err.println("");

        //language=JSON
        String json = "{\"key\":\"\"}";
        if (json != null) {
            json = null;

        }
        return "可以成功访问了。";
    }
}
