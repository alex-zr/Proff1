package ua.kiev.prog.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/user/{id}")
    public CustomUser getUser(@PathVariable Long id) {
        //
        return new CustomUser();
    }

    @DeleteMapping("/user/1")
    //
    @PostMapping("/user/1")
    //

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/register")
    public String registerPage() {
        return "register";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}
