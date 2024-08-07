package fp.dndmanagementsystem.model.dto.races;

import jakarta.persistence.Column;

public class RacesDTO {
    private String name;
    private String alignment;
    private String size_description;
    private String age;
    private String language_desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
