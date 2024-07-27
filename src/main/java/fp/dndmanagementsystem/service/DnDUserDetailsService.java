package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.entity.UserEntity;
import fp.dndmanagementsystem.model.entity.UserRoleEntity;
import fp.dndmanagementsystem.model.enums.UserRoleEnum;
import fp.dndmanagementsystem.model.user.DnDUserDetails;
import fp.dndmanagementsystem.repo.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DnDUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public DnDUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByName(username)
                .map(DnDUserDetailsService::map)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User with username " + username + " not found!"));
    }

    private static UserDetails map(UserEntity userEntity) {

        return new DnDUserDetails(
                userEntity.getName(),
                userEntity.getPassword(),
                userEntity.getRoles().stream().map(UserRoleEntity::getRole).map(DnDUserDetailsService::map).toList()//,
//                userEntity.getCharacters(),
//                userEntity.getCampaigns(),
//                userEntity.getManagedCampaigns()
        );
    }

    private static GrantedAuthority map(UserRoleEnum role) {
        return new SimpleGrantedAuthority(
                "ROLE_" + role
        );
    }
}
