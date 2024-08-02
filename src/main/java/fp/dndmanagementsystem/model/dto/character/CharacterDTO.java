package fp.dndmanagementsystem.model.dto.character;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CharacterDTO {
    private String race;
    private String characterClass;
    private String characterSubClass;
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

    private List<Integer> spells;
    private List<Integer> items;
    private int userId;

}
