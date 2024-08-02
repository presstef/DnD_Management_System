package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.model.dto.UserLoginDTO;
import fp.dndmanagementsystem.model.dto.UserRegistrationDTO;
import fp.dndmanagementsystem.repo.UserRepository;
import fp.dndmanagementsystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
