package fp.dndmanagementsystem.model.dto.spell;


public class SpellsDTO {
    private String name;
    private String description;
    private boolean concentration;
    private int level;
   // private String range;
   // @JsonProperty("attack_type")
    private String attack_type;
  //  @JsonProperty("casting_type")
    private String casting_time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConcentration() {
        return concentration;
    }

    public void setConcentration(boolean concentration) {
        this.concentration = concentration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
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

}
