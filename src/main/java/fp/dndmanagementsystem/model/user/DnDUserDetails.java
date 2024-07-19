package fp.dndmanagementsystem.model.user;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.UUID;

@Getter
public class DnDUserDetails extends User {

    private final UUID uuid;

    public DnDUserDetails(
            UUID uuid,
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities
    ) {
        super(username, password, authorities);
        this.uuid = uuid;
    }
}