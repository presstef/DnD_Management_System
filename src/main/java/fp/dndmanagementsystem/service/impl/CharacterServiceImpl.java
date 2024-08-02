package fp.dndmanagementsystem.service.impl;

import fp.dndmanagementsystem.model.dto.character.AddCharacterDTO;
import fp.dndmanagementsystem.model.dto.character.CharacterDTO;
import fp.dndmanagementsystem.model.entity.CharacterEntity;
import fp.dndmanagementsystem.repo.CharacterRepository;
import fp.dndmanagementsystem.service.CharacterService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {
   private final ModelMapper modelMapper;
   private final CharacterRepository characterRepository;

    public CharacterServiceImpl(ModelMapper modelMapper, CharacterRepository characterRepository) {
        this.modelMapper = modelMapper;
        this.characterRepository = characterRepository;
    }

    @Override
    public void createCharacter(AddCharacterDTO addCharacterDTO) {
        CharacterEntity character = modelMapper.map(addCharacterDTO, CharacterEntity.class);
        characterRepository.save(character);
    }

    @Override
    public void deleteCharacter(long id) {
        characterRepository.deleteById(id);
    }

    //TODO
    @Override
    public void updateCharacter(long id, CharacterDTO characterDTO) {
        characterRepository.findById(id).ifPresent(character -> {
            modelMapper.map(characterDTO, character);
        });
    }
}
