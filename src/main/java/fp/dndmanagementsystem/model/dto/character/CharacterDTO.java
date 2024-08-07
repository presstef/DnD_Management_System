package fp.dndmanagementsystem.model.dto.character;

import fp.dndmanagementsystem.model.entity.ItemEntity;
import fp.dndmanagementsystem.model.entity.SpellEntity;
import fp.dndmanagementsystem.model.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
public class CharacterDTO {
    private Long id;
    private String name;
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

    private List<SpellEntity> spells;
    private List<ItemEntity> items;
    private UserEntity user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getRace() {
        return race;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public double getMoney() {
        return money;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }


    public void setLevel(int level) {
        this.level = level;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public void setSpells(List<SpellEntity> spells) {
        this.spells = spells;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }

    public List<SpellEntity> getSpells() {
        return spells;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
