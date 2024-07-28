package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.AddCampaignDTO;
import fp.dndmanagementsystem.model.dto.CampaignDetailsDTO;
import fp.dndmanagementsystem.model.dto.CampaignSummaryDTO;

import java.util.List;


public interface CampaignService {
    void createCampaign(AddCampaignDTO addCampaignDTO);

    void deleteCampaign(long campaignId);

    CampaignDetailsDTO getCampaignDetails(Long id);

    List<CampaignSummaryDTO> getAllCampaignsSummary();
}
