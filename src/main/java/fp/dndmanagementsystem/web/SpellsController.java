package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.service.SpellService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spells")
public class SpellsController {
    private final SpellService spellService;

    public SpellsController(SpellService spellService) {
        this.spellService = spellService;
    }

    @GetMapping()
    public String getAllSpells(Model model) {
        model.addAttribute("spells", spellService.getAllSpells());
        return "spells";
    }
}
