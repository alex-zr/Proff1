package ua.kiev.prog;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class RegistrationController {

    Set<User> users = new HashSet<>();

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegister(Model model,
                                @RequestParam String username,
                                @RequestParam String password,
                                 User user) {


        if (!(user.getName().equalsIgnoreCase(username))&&user.getPassword().equalsIgnoreCase(password)){
            users.add(user);
        } else {
            return "wrongPage";
        }




        return "registerPage";
    }

}
