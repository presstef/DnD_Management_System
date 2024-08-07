package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="classes")
public class ClassEntity extends BaseEntity{
    private int hit_die;

    public int getHit_die() {
        return hit_die;
    }

    public void setHit_die(int hit_die) {
        this.hit_die = hit_die;
    }

}
