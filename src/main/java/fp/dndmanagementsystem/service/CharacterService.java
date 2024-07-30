package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.CharacterDTO;

public interface CharacterService {
    public void createCharacter(CharacterDTO character);

    void deleteCharacter(long id);

    void updateCharacter(long id, CharacterDTO characterDTO);
}
