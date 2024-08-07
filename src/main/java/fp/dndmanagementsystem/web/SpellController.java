package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.service.MonsterService;
import fp.dndmanagementsystem.service.SpellService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpellController {
    private final SpellService spellService;

    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }
}
