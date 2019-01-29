package ua.kiev.prog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kiev.prog.domain.User;
import ua.kiev.prog.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String logPage() {
        return "login";
    }

    @RequestMapping(value = "/reg_page")
    public String regPage() {
        return "registration";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logged(Model model,
                         @RequestParam String login,
                         @RequestParam String password,
                         HttpServletRequest request){
        if (userService.findByLogin(login) == null) {
            model.addAttribute("regMess", "Wrong login");

            return "login";
        }

        User user = userService.findByLogin(login);

        if (user.getPassword().compareTo(password) != 0) {
            model.addAttribute("regMess", "Wrong password");

            return "login";
        }

//        request.getRequestDispatcher("/index");
        return "index";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String onReg(Model model,
                        @RequestParam String login,
                        @RequestParam String password) {
        if ( userService.findByLogin(login) != null ) {
            model.addAttribute("regMess", "Wrong login");

            return "registration";
        }

        User user = new User(login,password);

        userService.addUser(user);

        model.addAttribute("regMess", "Registration Successful");

        return "login";
    }
}
