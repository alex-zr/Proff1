package ua.kiev.prog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegController {

    @RequestMapping(value = "/regform")
    public String regForm() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String onReg(Model model,
                        @RequestParam String login,
                        @RequestParam String password) {
        if (RegistratedUsers.checkLogin(login) == 1) {
            RegistratedUsers.newUser(login, password);
            model.addAttribute("regMes", "Successful");
        } else {
            model.addAttribute("regMes", "Wrong login");

            return "registration";
        }

        return "index_old";
    }
}
