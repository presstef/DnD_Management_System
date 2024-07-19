package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name="monsters")
public class MonsterEntity extends BaseEntity {

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int hitPoints;

    private String alignment;
    private int speed;
    private int armorClass;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private double challengeRating;

    @ManyToMany(mappedBy = "monsters")
    private Set<CampaignEntity> campaigns;

    public MonsterEntity() {
        campaigns = new HashSet<>();
    }
}
