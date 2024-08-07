package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.model.dto.character.AddCharacterDTO;
import fp.dndmanagementsystem.model.dto.character.CharacterDTO;
import fp.dndmanagementsystem.model.dto.spell.SpellsDTO;
import fp.dndmanagementsystem.model.entity.CharacterEntity;
import fp.dndmanagementsystem.model.entity.ItemEntity;
import fp.dndmanagementsystem.model.entity.SpellEntity;
import fp.dndmanagementsystem.model.entity.UserEntity;
import fp.dndmanagementsystem.service.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService characterService;
    private final SpellService spellService;
    private final ClassService characterClassService;
    private final RaceService raceService;
    private final ItemService itemService;
    private final UserService userService;

    public CharacterController(CharacterService characterService, SpellService spellService, ClassService characterClassService, RaceService raceService, ItemService itemService, UserService userService) {
        this.characterService = characterService;
        this.spellService = spellService;
        this.characterClassService = characterClassService;
        this.raceService = raceService;
        this.itemService = itemService;
        this.userService = userService;
    }

//TODO
    @GetMapping()
    public String getAllCharacters(Model model) {
        UserEntity currUser = userService.getCurrentUser();
        List<CharacterEntity> characters = characterService.getAllCharactersByUser(currUser);
            model.addAttribute("allCharacters", characters);
        return "characters";
    }



    @GetMapping("/add")
    public String showAddCharacterForm(Model model) {
        model.addAttribute("addCharacterDTO", new AddCharacterDTO());
        model.addAttribute("characterClasses", characterClassService.getAllClasses());
        model.addAttribute("characterRaces", raceService.getAllRaces());
        model.addAttribute("spells", spellService.getAllSpells());
        model.addAttribute("items", itemService.getAllItems());

        return "characters-add";
    }

    @GetMapping("/characters/spells")
    @ResponseBody
    public List<SpellEntity> getSpellsByLevel(@RequestParam int level) {
        return spellService.getSpellsByLevel(level);
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
    public String deleteCharacter(@PathVariable long id) {
        characterService.deleteCharacter(id);
        return "redirect:/characters";
    }

//    @GetMapping("/update/{id}")
//    public String showUpdateCharacterForm(@PathVariable long id, Model model) {
//        characterService.getCharacterById(id);
//        return
//    }
    @GetMapping("/update/{id}")
    public String showUpdateCharacter(@PathVariable long id, Model model) {
        model.addAttribute("CharacterDTO", characterService.getCharacterById(id));
        model.addAttribute("characterClasses", characterClassService.getAllClasses());
        model.addAttribute("characterRaces", raceService.getAllRaces());
        model.addAttribute("spells", spellService.getAllSpells());
        model.addAttribute("items", itemService.getAllItems());
        return "characters-update";
    }
    @PutMapping("/update/{id}")
    public String updateCharacter(@PathVariable long id, @Valid @ModelAttribute("CharacterDTO") CharacterDTO characterDTO,
                               BindingResult bindingResult, RedirectAttributes rAtt) {
        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("CharacterDTO", characterDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.CharacterDTO", bindingResult);
            return "redirect:/characters/add";
        }
        characterService.updateCharacter(id, characterDTO);
        return "redirect:/characters";
    }
}
