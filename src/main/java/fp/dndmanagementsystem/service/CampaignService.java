package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.campaign.AddCampaignDTO;
import fp.dndmanagementsystem.model.dto.campaign.CampaignDetailsDTO;
import fp.dndmanagementsystem.model.dto.campaign.CampaignSummaryDTO;

import java.util.List;


public interface CampaignService {
    void createCampaign(AddCampaignDTO addCampaignDTO);

    void deleteCampaign(long campaignId);

    CampaignDetailsDTO getCampaignDetails(Long id);

    List<CampaignSummaryDTO> getAllCampaignsSummary();
}
