package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.UserLoginDTO;
import fp.dndmanagementsystem.model.dto.UserRegistrationDTO;

import java.util.Optional;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegistration);
    boolean login(UserLoginDTO userLoginDTO);

    void logout();
}
