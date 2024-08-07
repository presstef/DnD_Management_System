package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.character.AddCharacterDTO;
import fp.dndmanagementsystem.model.dto.character.CharacterDTO;

public interface CharacterService {
    void createCharacter(AddCharacterDTO characterDTO);
    void getAllCharactersByUsername(String username);

    void deleteCharacter(long id);

    void updateCharacter(long id, CharacterDTO characterDTO);
}
