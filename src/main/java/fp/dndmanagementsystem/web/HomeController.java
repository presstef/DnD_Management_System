package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.model.user.DnDUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetails userDetails,
                       Model model) {

        if (userDetails instanceof DnDUserDetails dndUserDetails) {
            model.addAttribute("welcomeMessage", dndUserDetails.getUsername());
        } else {
            model.addAttribute("welcomeMessage", "Anonymous");
        }

        return "index";
    }
}
