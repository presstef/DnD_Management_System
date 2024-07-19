package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.UserRegistrationDTO;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegistration);
}
