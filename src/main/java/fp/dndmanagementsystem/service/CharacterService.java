package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.character.AddCharacterDTO;
import fp.dndmanagementsystem.model.dto.character.CharacterDTO;

public interface CharacterService {
    void createCharacter(AddCharacterDTO addCharacterDTO);

    void deleteCharacter(long id);

    void updateCharacter(long id, CharacterDTO characterDTO);
}
