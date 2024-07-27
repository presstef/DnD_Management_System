package fp.dndmanagementsystem.model.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class DnDUserDetails extends User {

    //TODO characters and campaigns??
//    private final List<CharacterEntity> charactersList;
//    private final List<CampaignEntity> campaignsList;
//    private final List<CampaignEntity> managedCampaigns;

    public DnDUserDetails(
            String username,
            String passwords,
            Collection<? extends GrantedAuthority> authorities//,
//            List<CharacterEntity> charactersList,
//            List<CampaignEntity> campaignsList,
//            List<CampaignEntity> managedCampaigns
    ) {
        super(username, passwords, authorities);
        //TODO this = new ArrayList()?
//        this.charactersList = charactersList;
//        this.campaignsList = campaignsList;
//        this.managedCampaigns = managedCampaigns;
    }



//    public List<CharacterEntity> getCharactersList() {
//        return charactersList;
//    }
//
//    public List<CampaignEntity> getCampaignsList() {
//        return campaignsList;
//    }
//
//    public List<CampaignEntity> getManagedCampaigns() {
//        return managedCampaigns;
//    }
}
