package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name="campaigns")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User dungeonMaster;

    @OneToMany
    @JoinColumn(name = "campaign_id")
    private Set<Character> characters;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "campaigns_monsters",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "monster_id"))
    private Set<Monster> monsters;

    public Campaign() {
        characters = new HashSet<>();
        monsters = new HashSet<>();
    }

}
