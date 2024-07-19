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
public class CampaignEntity extends BaseEntity{

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity dungeonMaster;

    @OneToMany
    @JoinColumn(name = "campaign_id")
    private Set<CharacterEntity> characters;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "campaigns_monsters",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "monster_id"))
    private Set<MonsterEntity> monsters;

    public CampaignEntity() {
        characters = new HashSet<>();
        monsters = new HashSet<>();
    }

}
