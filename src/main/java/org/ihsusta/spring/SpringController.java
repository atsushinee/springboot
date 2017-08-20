package org.ihsusta.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {

    @RequestMapping
    public String show(){
        return "hello";
    }
}
