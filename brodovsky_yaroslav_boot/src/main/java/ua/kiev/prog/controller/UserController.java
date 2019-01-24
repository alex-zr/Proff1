package ua.kiev.prog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @RequestMapping(value = "/")
    public String logPage() {
        return "login";
    }

    @RequestMapping(value = "/reg_page")
    public String regPage() {
        return "registration";
    }

    @RequestMapping(value = "/login")
    public String logged(@RequestParam String login,
                         @RequestParam String password){
        return "index";
    }

    @RequestMapping(value = "/registration")
    public String onReg(@RequestParam String login,
                        @RequestParam String password) {
        return "login";
    }
}
