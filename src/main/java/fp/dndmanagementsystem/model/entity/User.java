package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Character> characters;

    @OneToMany(mappedBy = "dungeonMaster")
    private Set<Campaign> campaigns;

    public User() {
        this.characters = new HashSet<>();
        this.campaigns = new HashSet<>();
    }

}
