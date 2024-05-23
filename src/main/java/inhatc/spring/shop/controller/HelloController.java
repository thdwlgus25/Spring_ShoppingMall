package inhatc.spring.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@Controller
public class HelloController {

//   옛날 방식? @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String hello() {
        return "hello";
    }
}
