package fp.dndmanagementsystem.service.impl;

import fp.dndmanagementsystem.model.entity.UserEntity;
import fp.dndmanagementsystem.repo.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class DnDUserDetailsService implements UserDetailsService {

   private final UserRepository userRepository;

    public DnDUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return userRepository
                .findByUsername(username)
                .map(DnDUserDetailsService::map)
                .orElseThrow(()->new UsernameNotFoundException("User with username" + username+ "not found"));
    }
    private static UserDetails map(UserEntity userEntity){
        return User
                .withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(List.of())/*TODO*/
                .disabled(false)
                .build();
    }
}
