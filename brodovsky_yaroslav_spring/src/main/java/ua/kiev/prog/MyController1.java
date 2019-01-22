package ua.kiev.prog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController1 {

    static {
        RegistratedUsers.newUser("user1", "password1");
        RegistratedUsers.newUser("user2", "password2");
    }

    @RequestMapping("/")
    public String index() {
        return "index_old";
    }

    @RequestMapping("/old")
    public String onIndex() {
        return "index_old";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String onLogin(Model model,
                          @RequestParam String login,
                          @RequestParam String password,
                          HttpServletRequest request) {
        String pass = RegistratedUsers.getPassword(login);

        model.addAttribute("login", login);
        if (password.equals(pass)) {
            model.addAttribute("message", "Success");
        } else {
            model.addAttribute("message", "Failure");
        }

        return "result_old";
    }
}
