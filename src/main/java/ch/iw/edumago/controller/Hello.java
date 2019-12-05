package ch.iw.edumago.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping("/api/v1/")
    public String home() {
        return "Hello Docker World";
    }
}