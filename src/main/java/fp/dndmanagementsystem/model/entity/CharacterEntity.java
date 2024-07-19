package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name="characters")
public class CharacterEntity extends BaseEntity{
    @Column(nullable = false)
    private String race;

    @Column(nullable = false)
    private String characterClass;

    @Column(nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "characters_spells",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "spell_id"))
    private Set<SpellEntity> spells;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private CampaignEntity campaign;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "characters_items",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<ItemEntity> items;

    public CharacterEntity() {
    }

}
