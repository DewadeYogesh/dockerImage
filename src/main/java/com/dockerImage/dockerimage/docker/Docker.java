package com.dockerImage.dockerimage.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Docker {

    @GetMapping("/message")
    public String  getmessage(){
        return "Hello Yogesh " + "Good Morning! ";
    }
}


