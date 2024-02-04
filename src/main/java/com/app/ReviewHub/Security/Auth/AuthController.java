package com.app.ReviewHub.Security.Auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
    @RequestMapping("/login")
    public String login() {
        System.out.println("allo");
        return "login";
    }
}
