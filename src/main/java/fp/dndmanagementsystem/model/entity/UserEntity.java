package fp.dndmanagementsystem.model.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<CharacterEntity> characters;

    @ManyToMany(mappedBy = "participants")
    private List<CampaignEntity> campaigns;

    @OneToMany(mappedBy = "dungeonMaster")
    private List<CampaignEntity> managedCampaigns;

    public UserEntity() {
        this.characters = new ArrayList<>();
        this.campaigns = new ArrayList<>();
        this.managedCampaigns = new ArrayList<>();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CharacterEntity> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterEntity> characters) {
        this.characters = characters;
    }

    public List<CampaignEntity> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<CampaignEntity> campaigns) {
        this.campaigns = campaigns;
    }

    public List<CampaignEntity> getManagedCampaigns() {
        return managedCampaigns;
    }

    public void setManagedCampaigns(List<CampaignEntity> managedCampaigns) {
        this.managedCampaigns = managedCampaigns;
    }
}
