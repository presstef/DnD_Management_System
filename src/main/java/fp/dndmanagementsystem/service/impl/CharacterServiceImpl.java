package fp.dndmanagementsystem.service.impl;

import fp.dndmanagementsystem.model.dto.character.AddCharacterDTO;
import fp.dndmanagementsystem.model.dto.character.CharacterDTO;
import fp.dndmanagementsystem.model.entity.CharacterEntity;
import fp.dndmanagementsystem.model.entity.UserEntity;
import fp.dndmanagementsystem.model.user.DnDUserDetails;
import fp.dndmanagementsystem.repo.CharacterRepository;
import fp.dndmanagementsystem.repo.UserRepository;
import fp.dndmanagementsystem.service.CharacterService;
import fp.dndmanagementsystem.service.DnDUserDetailsService;
import fp.dndmanagementsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {
   private final ModelMapper modelMapper;
   private final CharacterRepository characterRepository;
      private final UserRepository userRepository;


    public CharacterServiceImpl(ModelMapper modelMapper, CharacterRepository characterRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.characterRepository = characterRepository;
        this.userRepository = userRepository;
     //   this.dndUserDetails = dndUserDetails;
       // this.dnDUserDetailsService = dnDUserDetailsService;
    }

    @Override
    public void createCharacter(AddCharacterDTO characterDTO) {
//        UserEntity currUser = getCurrentUserId();
      //  characterDTO.setUser(currUser);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // DnDUserDetails dnDUserDetails = (DnDUserDetails) authentication.getPrincipal();
        Optional<UserEntity> currUser = userRepository.findByName(authentication.getName());
        CharacterEntity character = modelMapper.map(characterDTO, CharacterEntity.class);
        character.setUser(currUser.get());
        characterRepository.save(character);
    }

    @Override
    public void getAllCharactersByUsername(String username) {

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

/*
   private UserEntity getCurrentUserId(){
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       UserEntity currUser =  ((UserEntity) authentication.getPrincipal());
       System.out.println(currUser.getId() + " " + currUser.getName());
       return currUser;
    }
*/
}
