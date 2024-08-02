package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="campaigns")
public class CampaignEntity extends BaseEntity{

    @NotEmpty
    private String description;

//    @ManyToOne
//    @JoinColumn(name = "dungeon_master_id")
//    private UserEntity dungeonMaster;

    @Setter
    @Getter
    @ManyToMany
    @JoinTable(
            name = "campaigns_characters",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private List<CharacterEntity> characters;

    @Setter
    @Getter
    @ManyToMany
    @JoinTable(
            name = "campaigns_monsters",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "monster_id")
    )
    private List<MonsterEntity> monsters;

    @Setter
    @Getter
    @ManyToMany
    @JoinTable(
            name = "users_campaigns",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserEntity> participants;

    public CampaignEntity() {
        this.characters = new ArrayList<>();
        this.monsters = new ArrayList<>();
        this.participants = new ArrayList<>();
    }

//    public UserEntity getDungeonMaster() {
//        return dungeonMaster;
//    }
//
//    public void setDungeonMaster(UserEntity dungeonMaster) {
//        this.dungeonMaster = dungeonMaster;
//    }

}
