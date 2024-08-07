package fp.dndmanagementsystem.service.impl;

import fp.dndmanagementsystem.model.dto.character.AddCharacterDTO;
import fp.dndmanagementsystem.model.dto.character.CharacterDTO;
import fp.dndmanagementsystem.model.dto.monster.MonstersDTO;
import fp.dndmanagementsystem.model.entity.CharacterEntity;
import fp.dndmanagementsystem.model.entity.UserEntity;
import fp.dndmanagementsystem.repo.CharacterRepository;
import fp.dndmanagementsystem.repo.UserRepository;
import fp.dndmanagementsystem.service.CharacterService;
import fp.dndmanagementsystem.service.SpellService;
import fp.dndmanagementsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {
   private final ModelMapper modelMapper;
   private final CharacterRepository characterRepository;
      private final UserRepository userRepository;
      private final SpellService spellService;
      private final UserService userService;


    public CharacterServiceImpl(ModelMapper modelMapper, CharacterRepository characterRepository, UserRepository userRepository, SpellService spellService, UserService userService) {
        this.modelMapper = modelMapper;
        this.characterRepository = characterRepository;
        this.userRepository = userRepository;
        this.spellService = spellService;
        this.userService = userService;
    }

    @Override
    public void createCharacter(AddCharacterDTO characterDTO) {

        UserEntity currUser = userService.getCurrentUser();

        CharacterEntity character = modelMapper.map(characterDTO, CharacterEntity.class);
        character.setUser(currUser);
        characterRepository.save(character);
    }

    @Override
    public List<CharacterEntity> getAllCharactersByUser(UserEntity user) {
        return characterRepository.getAllByUser(user);
    }

    @Override
    public void deleteCharacter(long id) {
        characterRepository.deleteById(id);
    }

    //TODO
    @Override
    public void updateCharacter(long id, CharacterDTO characterDTO) {
        CharacterEntity character = characterRepository.findById(id).get();
        modelMapper.map(characterDTO, character);
        character.setUser(userService.getCurrentUser());
        characterRepository.save(character);
    }

    @Override
    public CharacterDTO getCharacterById(long id) {
        return modelMapper.map(characterRepository.findById(id).get(), CharacterDTO.class);
    }

/*
   private UserEntity getCurrentUserId(){
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       UserEntity currUser =  ((UserEntity) authentication.getPrincipal());
       System.out.println(currUser.getId() + " " + currUser.getName());
       return currUser;
    }
*/
}
