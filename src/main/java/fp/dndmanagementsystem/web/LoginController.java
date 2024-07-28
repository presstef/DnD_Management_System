package fp.dndmanagementsystem.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {

    //TODO login instead of index??
    @GetMapping("/login")
    public String index() {
        return "login";
    }
}
