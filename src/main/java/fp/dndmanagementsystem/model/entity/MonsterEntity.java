package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="monsters")
public class MonsterEntity extends BaseEntity {
//TODO fix names with camelCase
    private String type;
    private String size;
    private String alignment;

    private int hit_points;
    //TODO if enough time
   //private int speed;
   // private int armorClass;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    //TODO image

//    @Column(name = "challenge_rating")
//    private double challengeRating;

    @ManyToMany(mappedBy = "monsters")
    private List<CampaignEntity> campaigns;

    public MonsterEntity() {
        campaigns = new ArrayList<>();
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getHit_points() {
        return hit_points;
    }

    public void setHit_points(int hit_points) {
        this.hit_points = hit_points;
    }

    public List<CampaignEntity> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<CampaignEntity> campaigns) {
        this.campaigns = campaigns;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

//    public int getSpeed() {
//        return speed;
//    }
//
//    public void setSpeed(int speed) {
//        this.speed = speed;
//    }
//
//    public int getArmorClass() {
//        return armorClass;
//    }
//
//    public void setArmorClass(int armorClass) {
//        this.armorClass = armorClass;
//    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

//    public double getChallengeRating() {
//        return challengeRating;
//    }
//
//    public void setChallengeRating(double challengeRating) {
//        this.challengeRating = challengeRating;
//    }
}
