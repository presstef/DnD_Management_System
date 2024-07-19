package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name="items")
public class ItemEntity extends BaseEntity {

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String category;

    @ManyToMany(mappedBy =  "items")
    private Set<CharacterEntity> characters;

    private double price;

    private double weight;

    public ItemEntity() {
        characters = new HashSet<>();
    }
}
