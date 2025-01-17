package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="spells")
public class SpellEntity extends BaseEntity{

    @Column(length=1000)
    private String description;
    private boolean concentration;
    private int level;
   // private String range;
    private String attack_type;
    private String casting_time;

    @ManyToMany(mappedBy = "spells")
    private List<CharacterEntity> characters;

    public SpellEntity() {
        characters = new ArrayList<>();
    }

    public boolean isConcentration() {
        return concentration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setConcentration(boolean concentration) {
        this.concentration = concentration;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAttack_type() {
        return attack_type;
    }

    public void setAttack_type(String attack_type) {
        this.attack_type = attack_type;
    }

    public String getCasting_time() {
        return casting_time;
    }

    public void setCasting_time(String casting_time) {
        this.casting_time = casting_time;
    }

    public List<CharacterEntity> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterEntity> characters) {
        this.characters = characters;
    }
}

