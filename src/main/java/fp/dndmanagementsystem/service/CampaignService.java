package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.AddCampaignDTO;

public class CampaignService {
    void createCampaign(AddCampaignDTO addCampaignDTO);

    void editCmapaign(long campaignId);

    void deleteCmapaign(long campaignId);

    CampaignDetailsDTO getCampaignDetails(Long id);

    List<CampaignSummaryDTO> getAllCampaignsSummary();
}
