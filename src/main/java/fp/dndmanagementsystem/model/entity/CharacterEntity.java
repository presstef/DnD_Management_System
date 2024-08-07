package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="characters")
public class CharacterEntity extends BaseEntity{
    private String race;
    private String characterClass;
    private int level;
    private int hp;
    private double money;
    private int armorClass;
    private int speed;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    //TODO spells and items
    @ManyToMany
    @JoinTable(
            name = "characters_spells",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "spell_id")
    )
    private List<SpellEntity> spells;

    @ManyToMany
    @JoinTable(
            name = "characters_items",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemEntity> items;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

//    @ManyToMany
//    @JoinTable(
//            name = "characters_campaigns",
//            joinColumns = @JoinColumn(name = "character_id"),
//            inverseJoinColumns = @JoinColumn(name = "campaign_id")
//    )
//    private List<CampaignEntity> campaigns;

    public CharacterEntity() {
        spells=new ArrayList<>();
        items=new ArrayList<>();
    }

    //    public List<CampaignEntity> getCampaigns() {
//        return campaigns;
//    }
//
//    public void setCampaigns(List<CampaignEntity> campaigns) {
//        this.campaigns = campaigns;
//    }


    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

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

    public List<SpellEntity> getSpells() {
        return spells;
    }

    public void setSpells(List<SpellEntity> spells) {
        this.spells = spells;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
