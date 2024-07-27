package fp.dndmanagementsystem.service.impl;

import fp.dndmanagementsystem.model.dto.AddCampaignDTO;
import fp.dndmanagementsystem.model.dto.CampaignDetailsDTO;
import fp.dndmanagementsystem.model.dto.CampaignSummaryDTO;
import fp.dndmanagementsystem.model.entity.CampaignEntity;
import fp.dndmanagementsystem.repo.CampaignRepository;
import fp.dndmanagementsystem.service.CurrentUser;
import fp.dndmanagementsystem.service.MonsterService;
import org.springframework.stereotype.Service;
import fp.dndmanagementsystem.service.CampaignService;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService{

    private final CampaignRepository campaignRepository;
    private final MonsterService monsterService;
    private final CurrentUser currentUser;

    public CampaignServiceImpl(CampaignRepository campaignRepository, MonsterService monsterService, CurrentUser currentUser) {
        this.campaignRepository = campaignRepository;
        this.monsterService = monsterService;
        this.currentUser = currentUser;
    }

    @Override
    public long createCampaign(AddCampaignDTO addCampaignDTO) {
        return campaignRepository.save(map(addCampaignDTO)).getId();
    }

    @Override
    public void deleteCampaign(long campaignId) {
        campaignRepository.deleteById(campaignId);
    }

    @Override
    public CampaignDetailsDTO getCampaignDetails(Long id) {
        return this.campaignRepository
                .findById(id)
                .map(this::toCampaignDetails)
                .orElseThrow();
    }

    @Override
    public List<CampaignSummaryDTO> getAllCampaignsSummary() {
        return campaignRepository
                .findAll()
                .stream()
                .map(CampaignServiceImpl::toCampaignSummary)
                .toList();
    }

    private static CampaignSummaryDTO toCampaignSummary(CampaignEntity campaignEntity) {
        // todo use mapping library
        return new CampaignSummaryDTO(campaignEntity.getId(),
                campaignEntity.getDescription());
    }


    private CampaignDetailsDTO toCampaignDetails(CampaignEntity campaignEntity) {
        // todo use mapping library
        return new CampaignDetailsDTO(campaignEntity.getId(),
                campaignEntity.getName(),
                campaignEntity.getDescription(),
                campaignEntity.getDungeonMaster(),
                campaignEntity.getCharacters(),
                campaignEntity.getMonsters()
        );
    }

    private static CampaignEntity map(AddCampaignDTO addCampaignDTO) {
        // todo - use mapped (e.g. ModelMapper)
        CampaignEntity ce = new CampaignEntity();
        ce.setName(addCampaignDTO.name());
        ce.setDescription(addCampaignDTO.description());
        //TODO loggedInUser
        //ce.setDungeonMaster();

        return ce;
    }
}
