package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.model.dto.character.AddCharacterDTO;
import fp.dndmanagementsystem.model.dto.character.CharacterDTO;
import fp.dndmanagementsystem.service.CharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping("/add")
    public void addCharacter(@RequestParam AddCharacterDTO addCharacterDTO) {
        characterService.createCharacter(addCharacterDTO);
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
