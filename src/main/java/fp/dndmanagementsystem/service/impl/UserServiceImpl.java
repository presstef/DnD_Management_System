package fp.dndmanagementsystem.service.impl;

import fp.dndmanagementsystem.model.dto.UserRegistrationDTO;
import fp.dndmanagementsystem.model.entity.UserEntity;
import fp.dndmanagementsystem.model.entity.UserRoleEntity;
import fp.dndmanagementsystem.model.enums.UserRoleEnum;
import fp.dndmanagementsystem.repo.UserRepository;
import fp.dndmanagementsystem.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void registerUser(UserRegistrationDTO userRegistration) {
        try {
            UserEntity user = this.modelMapper.map(userRegistration, UserEntity.class);
            UserRoleEntity role = new UserRoleEntity();
            UserRoleEnum userRole = userRepository.count() == 0 ? UserRoleEnum.ADMIN : UserRoleEnum.USER;
            role.setId((userRole.name().equals("ADMIN") ? 1L: 2L));
            role.setRole(userRole);

            user.setRole(role);
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));

            userRepository.save(user);
            logger.info("User registered successfully with role: {}", userRole);
        } catch (Exception e) {
            logger.error("Error registering user", e);
            throw new RuntimeException("Failed to register user", e);
        }
    }


//    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {
//        UserEntity mappedEntity = modelMapper.map(userRegistrationDTO, UserEntity.class);
//
//        mappedEntity.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
//
//        return mappedEntity;
//    }

}