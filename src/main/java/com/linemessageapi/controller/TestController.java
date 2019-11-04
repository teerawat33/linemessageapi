package com.linemessageapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @RequestMapping("/test")
    public List<String> test(String aa){

        List<String> strings = new ArrayList<>();

        for (int i = 0 ; i == 100 ; i++){

            strings.add(aa);
        }

        return strings;
    }

}
