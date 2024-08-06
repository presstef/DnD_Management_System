package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.service.MonsterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monsters")
public class MonstersController {
    private final MonsterService monsterService;

    public MonstersController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }
    @GetMapping()
    public String getAllMonsters(Model model) {
        model.addAttribute("monsters", monsterService.getAllMonsters());
        return "monsters";
    }
}
