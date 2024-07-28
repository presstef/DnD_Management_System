package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.model.dto.UserRegistrationDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {

    //TODO login instead of index??
    @GetMapping("/login")
    public String login() {
        return "login";
    }

//    @PostMapping("/login")
//    public String home() {
//        return "redirect:/";
//    }
}
