package fp.dndmanagementsystem.init;

import fp.dndmanagementsystem.service.ItemService;
import fp.dndmanagementsystem.service.MonsterService;
import fp.dndmanagementsystem.service.SpellService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
//@ConditionalOnProperty(name = "dnd5eapi.init-monsters", havingValue = "true")
public class Initializer implements CommandLineRunner {
    private final MonsterService monsterService;
    private final SpellService spellService;
    private final ItemService itemService;
   // private final BoonService boonService;
    //TODO classes and races


    public Initializer(MonsterService monsterService, SpellService spellService, ItemService itemService/*, BoonService boonService*/) {
        this.monsterService = monsterService;
        this.spellService = spellService;
        this.itemService = itemService;
     //   this.boonService = boonService;
    }

    @Override
    public void run(String... args) throws IOException {
      // BoonDTO boon =  boonService.getRandomBoon();
        if (!monsterService.hasInitializedMonsters()) {
            monsterService.updateMonsters(
                    monsterService.fetchMonsters()
            );
        }
        if (!spellService.hasInitializedSpells()) {
            spellService.updateSpells(
                    spellService.fetchSpells()
            );
        }
        if (!itemService.hasInitializedItems()) {
            itemService.updateItems(
                    itemService.fetchItems()
            );
        }
    }
}
