package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.UserRegistrationDTO;
import fp.dndmanagementsystem.model.entity.UserEntity;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegistration);
    UserEntity getCurrentUser();
    //void login(UserLoginDTO loginDTO);
    //void loginUser(UserLoginDTO userLogin);
}
