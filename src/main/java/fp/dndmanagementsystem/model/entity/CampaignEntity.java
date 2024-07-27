package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="campaigns")
public class CampaignEntity extends BaseEntity{

    @NotEmpty
    private String description;

    @ManyToOne
    @JoinColumn(name = "dungeon_master_id")
    private UserEntity dungeonMaster;

    @ManyToMany
    @JoinTable(
            name = "campaigns_characters",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private List<CharacterEntity> characters;

    @ManyToMany
    @JoinTable(
            name = "campaigns_monsters",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "monster_id")
    )
    private List<MonsterEntity> monsters;

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

    public @NotEmpty String getDescription() {
        return description;
    }

    public void setDescription(@NotEmpty String description) {
        this.description = description;
    }

    public UserEntity getDungeonMaster() {
        return dungeonMaster;
    }

    public void setDungeonMaster(UserEntity dungeonMaster) {
        this.dungeonMaster = dungeonMaster;
    }

    public List<CharacterEntity> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterEntity> characters) {
        this.characters = characters;
    }

    public List<MonsterEntity> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<MonsterEntity> monsters) {
        this.monsters = monsters;
    }

    public List<UserEntity> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserEntity> participants) {
        this.participants = participants;
    }
}
