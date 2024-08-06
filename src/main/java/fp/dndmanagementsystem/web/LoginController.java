package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.model.dto.UserLoginDTO;
import fp.dndmanagementsystem.model.dto.UserRegistrationDTO;
import fp.dndmanagementsystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    public String doLogin(@Valid UserLoginDTO loginDTO) {
        this.userService.login(loginDTO);
        return "redirect:/users/home";
    }

}
