package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false)
    private String password;

//    @OneToMany(mappedBy = "user")
//    private List<CharacterEntity> characters;
//
//    @ManyToMany(mappedBy = "participants")
//    private List<CampaignEntity> campaigns;
//
//    @OneToMany(mappedBy = "dungeonMaster")
//    private List<CampaignEntity> managedCampaigns;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private UserRoleEntity role;

    public UserEntity() {
//        this.characters = new ArrayList<>();
//        this.campaigns = new ArrayList<>();
//        this.managedCampaigns = new ArrayList<>();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<CharacterEntity> getCharacters() {
//        return characters;
//    }
//
//    public void setCharacters(List<CharacterEntity> characters) {
//        this.characters = characters;
//    }
//
//    public List<CampaignEntity> getCampaigns() {
//        return campaigns;
//    }
//
//    public void setCampaigns(List<CampaignEntity> campaigns) {
//        this.campaigns = campaigns;
//    }
//
//    public List<CampaignEntity> getManagedCampaigns() {
//        return managedCampaigns;
//    }
//
//    public void setManagedCampaigns(List<CampaignEntity> managedCampaigns) {
//        this.managedCampaigns = managedCampaigns;
//    }

    public UserRoleEntity getRole() {
        return role;
    }

    public void setRole(UserRoleEntity role) {
        this.role = role;
    }

    //TODO to String maybe
}
