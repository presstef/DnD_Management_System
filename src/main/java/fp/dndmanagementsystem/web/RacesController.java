package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.service.RaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/races")
public class RacesController {
    private final RaceService raceService;

    public RacesController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping()
    public String getAllRaces(Model model) {
        model.addAttribute("races", raceService.getAllRaces());
        return "races";
    }
}
