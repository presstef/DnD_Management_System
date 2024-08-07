package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.character.AddCharacterDTO;
import fp.dndmanagementsystem.model.dto.character.CharacterDTO;
import fp.dndmanagementsystem.model.entity.CharacterEntity;
import fp.dndmanagementsystem.model.entity.UserEntity;

import java.util.List;

public interface CharacterService {
    void createCharacter(AddCharacterDTO characterDTO);
    List<CharacterEntity> getAllCharactersByUser(UserEntity user);

    void deleteCharacter(long id);

    void updateCharacter(long id, CharacterDTO characterDTO);

    CharacterDTO getCharacterById(long id);
}
