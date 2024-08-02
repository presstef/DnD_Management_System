package fp.dndmanagementsystem.service.impl;

import fp.dndmanagementsystem.model.dto.BoonDTO;
import fp.dndmanagementsystem.service.BoonService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class BoonServiceImpl implements BoonService {

    private Logger LOGGER = LoggerFactory.getLogger(BoonServiceImpl.class);
    private final RestClient boonRestClient;

    public BoonServiceImpl(@Qualifier("boonsRestClient") RestClient  boonRestClient) {
        this.boonRestClient = boonRestClient;
    }

    public BoonDTO getRandomBoon(){
        return boonRestClient
                .get()
                .uri("/boons/randomBoon")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(BoonDTO.class);
    }

//    @Override
//    public void createBoon(AddCampaignDTO addCampaignDTO) {
//        LOGGER.info("Creating new campaign...");
//
//        campaignRestClient
//                .post()
//                .uri("http://localhost:8081/campaigns")
//                .body(addCampaignDTO)
//                .retrieve();
//    }

//    @Override
//    public void deleteCampaign(long campaignId) {
//        campaignRepository.deleteById(campaignId);
//    }

//    @Override
//    public CampaignDetailsDTO getCampaignDetails(Long id) {
//        return campaignRestClient
//                .get()
//                .uri("http://localhost:8081/campaigns/{id}", id)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(CampaignDetailsDTO.class);
//    }

//    @Override
//    public List<CampaignSummaryDTO> getAllCampaignsSummary() {
//        LOGGER.info("Get all campaigns...");
//        return campaignRestClient
//                .get()
//                .uri("http://localhost:8081/campaigns")
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(new ParameterizedTypeReference<>() {
//                });
//    }
}
