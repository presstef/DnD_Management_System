package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="characters")
public class CharacterEntity extends BaseEntity{
//    @Column(nullable = false)
//    private String race;
//
//    @Column(nullable = false)
//    private String characterClass;
//
//    @Column(nullable = false)
//    private String characterSubClass;
//
//    private int level;
//
//    private int hp;
//
//    private double money;
//
//    private int armorClass;
//    private int speed;
//    private int strength;
//    private int dexterity;
//    private int constitution;
//    private int intelligence;
//    private int wisdom;
//    private int charisma;

    //TODO spells and items

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToMany
    @JoinTable(
            name = "characters_campaigns",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "campaign_id")
    )
    private List<CampaignEntity> campaigns;

    public CharacterEntity() {
        campaigns=new ArrayList<>();
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<CampaignEntity> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<CampaignEntity> campaigns) {
        this.campaigns = campaigns;
    }
}
