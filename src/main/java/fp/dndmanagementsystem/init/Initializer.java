package fp.dndmanagementsystem.init;

import fp.dndmanagementsystem.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
//@ConditionalOnProperty(name = "dnd5eapi.init-monsters", havingValue = "true")
public class Initializer implements CommandLineRunner {
   /* private final MonsterService monsterService;
    private final SpellService spellService;
    private final ItemService itemService;*/
    private final RaceService raceService;
   // private final BoonService boonService;
    private final ClassService classService;
    //TODO classes and races


    public Initializer(/*MonsterService monsterService, SpellService spellService, ItemService itemService,*/ RaceService raceService, ClassService classService/*, BoonService boonService*/) {
        this.classService = classService;
       /* this.monsterService = monsterService;
        this.spellService = spellService;
        this.itemService = itemService;*/
     //   this.boonService = boonService;
        this.raceService = raceService;
    }

    @Override
    public void run(String... args) throws IOException {
      // BoonDTO boon =  boonService.getRandomBoon();
      /*  if (!monsterService.hasInitializedMonsters()) {
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
        }*/
        if (!raceService.hasInitializedRaces()) {
            raceService.updateRaces(
                    raceService.fetchRaces()
            );
        }
        if (!classService.hasInitializedClasses()) {
            classService.updateClasses(
                    classService.fetchClasses()
            );
        }
    }
}
