package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "races")
public class RaceEntity extends BaseEntity {
    @Column(length=1000)
    private String alignment;
    @Column(length=1000)
    private String size_description;
    @Column(length=1000)
    private String age;
    @Column(length=1000)
    private String language_desc;

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getSize_description() {
        return size_description;
    }

    public void setSize_description(String size_description) {
        this.size_description = size_description;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLanguage_desc() {
        return language_desc;
    }

    public void setLanguage_desc(String language_desc) {
        this.language_desc = language_desc;
    }
}
