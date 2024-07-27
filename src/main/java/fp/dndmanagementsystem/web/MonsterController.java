package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.service.MonsterService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonsterController {

    private final MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }
}
