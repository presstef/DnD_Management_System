package fp.dndmanagementsystem.init;

import fp.dndmanagementsystem.service.MonsterService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "dnd5eapi.init-monsters", havingValue = "true")
public class MonstersInitializer implements CommandLineRunner {
    private final MonsterService monsterService;

    public MonstersInitializer(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!monsterService.hasInitializedMonsters()) {
            monsterService.updateMonsters(
                    monsterService.fetchMonsters()
            );
        }
    }
}
