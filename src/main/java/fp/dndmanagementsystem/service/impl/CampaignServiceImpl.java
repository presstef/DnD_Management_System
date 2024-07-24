package fp.dndmanagementsystem.service.impl;

import fp.dndmanagementsystem.model.dto.AddCampaignDTO;
import fp.dndmanagementsystem.model.dto.CampaignDetailsDTO;
import fp.dndmanagementsystem.model.dto.CampaignSummaryDTO;
import org.springframework.stereotype.Service;
import fp.dndmanagementsystem.service.CampaignService;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService{
    @Override
    public void createCampaign(AddCampaignDTO addCampaignDTO) {

    }

    @Override
    public void editCampaign(long campaignId) {

    }

    @Override
    public void deleteCampaign(long campaignId) {

    }

    @Override
    public CampaignDetailsDTO getCampaignDetails(Long id) {
        return null;
    }

    @Override
    public List<CampaignSummaryDTO> getAllCampaignsSummary() {
        return List.of();
    }
}
