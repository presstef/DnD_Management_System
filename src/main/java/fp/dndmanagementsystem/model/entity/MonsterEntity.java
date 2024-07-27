package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="monsters")
public class MonsterEntity extends BaseEntity {

//    @Column(nullable = false)
//    private String type;
//
//    @Column(nullable = false)
//    private int hitPoints;
//
//    private String alignment;
//    private int speed;
//    private int armorClass;
//    private int strength;
//    private int dexterity;
//    private int constitution;
//    private int intelligence;
//    private int wisdom;
//    private int charisma;
//    private double challengeRating;

    @ManyToMany(mappedBy = "monsters")
    private List<CampaignEntity> campaigns;

    public MonsterEntity() {
        campaigns = new ArrayList<>();
    }

    public List<CampaignEntity> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<CampaignEntity> campaigns) {
        this.campaigns = campaigns;
    }
}
