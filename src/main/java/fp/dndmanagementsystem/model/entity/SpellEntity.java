package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name="spells")
public class SpellEntity extends BaseEntity{

    @Column(nullable = false)
    private String description;

    private boolean concentration;

    private int level;

    private String damageType;

    private int castingTime;

    @ManyToMany(mappedBy = "spells")
    private Set<CharacterEntity> characters;

    public SpellEntity() {
        characters = new HashSet<>();
    }
}
