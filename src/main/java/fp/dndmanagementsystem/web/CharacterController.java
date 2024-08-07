package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.model.dto.character.AddCharacterDTO;
import fp.dndmanagementsystem.model.dto.character.CharacterDTO;
import fp.dndmanagementsystem.service.CharacterService;
import fp.dndmanagementsystem.service.ClassService;
import fp.dndmanagementsystem.service.RaceService;
import fp.dndmanagementsystem.service.SpellService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService characterService;
    private final SpellService spellService;
    private final ClassService characterClassService;
    private final RaceService raceService;

    public CharacterController(CharacterService characterService, SpellService spellService, ClassService characterClassService, RaceService raceService) {
        this.characterService = characterService;
        this.spellService = spellService;
        this.characterClassService = characterClassService;
        this.raceService = raceService;
    }

//    @PostMapping("/add")
//    public void addCharacter(@RequestParam AddCharacterDTO addCharacterDTO) {
//        characterService.createCharacter(addCharacterDTO);
//    }
//TODO
//    @GetMapping("/all")
//    public String getAllCharacters(Model model) {
//            model.addAttribute("allCampaigns", characterService.);
//        return "characters";
//    }


//    @GetMapping("/spells")
//    public String getSpells(Model model) {
//         model.addAttribute("spells", spellService.getAllSpellNames());
//         return "spells";
//    }

    //TODO for spells and items too
    @GetMapping("/add")
    public String showAddCharacterForm(Model model) {
        model.addAttribute("addCharacterDTO", new AddCharacterDTO());
        model.addAttribute("characterClasses", characterClassService.getAllClasses());
        model.addAttribute("characterRaces", raceService.getAllRaces());

        return "characters-add";
    }

    @PostMapping("/add")
    public String addCharacter(@Valid @ModelAttribute("AddCharacterDTO") AddCharacterDTO characterDTO,
                               BindingResult bindingResult, RedirectAttributes rAtt) {
        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("AddCharacterDTO", characterDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.AddCharacterDTO", bindingResult);
            return "redirect:/characters/add";
        }
        characterService.createCharacter(characterDTO);
        return "redirect:/characters";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCharacter(@PathVariable long id) {
        characterService.deleteCharacter(id);
    }

    @PutMapping("/update/{id}")
    public void updateCharacter(@PathVariable long id, @RequestParam CharacterDTO characterDTO) {
        characterService.updateCharacter(id, characterDTO);
    }
}
