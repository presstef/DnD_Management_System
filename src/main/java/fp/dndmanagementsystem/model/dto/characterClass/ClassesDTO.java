package fp.dndmanagementsystem.model.dto.characterClass;

public class ClassesDTO {
    private String name;
    private int hit_die;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHit_die() {
        return hit_die;
    }

    public void setHit_die(int hit_die) {
        this.hit_die = hit_die;
    }
}
