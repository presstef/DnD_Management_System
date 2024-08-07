package fp.dndmanagementsystem.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import fp.dndmanagementsystem.config.DnD5eApiConfig;
import fp.dndmanagementsystem.model.dto.races.RacesDTO;
import fp.dndmanagementsystem.model.dto.races.RaceResponseDTO;
import fp.dndmanagementsystem.model.dto.races.RaceResponseResultsDTO;
import fp.dndmanagementsystem.model.entity.RaceEntity;
import fp.dndmanagementsystem.model.mapper.RaceMapper;
import fp.dndmanagementsystem.repo.RaceRepository;
import fp.dndmanagementsystem.service.RaceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class RaceServiceImpl implements RaceService {
    private final RaceRepository raceRepository;
    private final RestClient restClient;
    private final DnD5eApiConfig dnd5eApiConfig;
    private final RaceMapper raceMapper;
    private final ModelMapper modelMapper;

    public RaceServiceImpl(RaceRepository raceRepository, @Qualifier("genericRestClient") RestClient restClient, DnD5eApiConfig dnd5eApiConfig, RaceMapper raceMapper, ModelMapper modelMapper) {
        this.raceRepository = raceRepository;
        this.restClient = restClient;
        this.dnd5eApiConfig = dnd5eApiConfig;
        this.raceMapper = raceMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean hasInitializedRaces() {
        return raceRepository.count() > 0;
    }

    @Override
    public List<RacesDTO> fetchRaces() {
        RaceResponseDTO fetchedResponse = restClient
                .get()
                .uri(dnd5eApiConfig.getUrl() + "/races")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(RaceResponseDTO.class);

        List<RacesDTO>  races = new ArrayList<>();

        for (RaceResponseResultsDTO currRace : fetchedResponse.results()){
            JsonNode fetchStatsResult = restClient
                    .get()
                    .uri(dnd5eApiConfig.getUrl() + "/races/" + currRace.index())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(JsonNode.class);

            races.add(raceMapper.jsonToRacesDTO(fetchStatsResult));
        }
        return races;
    }

    @Override
    public void updateRaces(List<RacesDTO> races) {
        if(!races.isEmpty()){
            races.forEach(r-> {
                RaceEntity raceEntity = raceRepository.findByName(r.getName())
                        .orElseGet(RaceEntity::new);

                raceEntity = modelMapper.map(r, RaceEntity.class);
                raceRepository.save(raceEntity);
            });}
    }

    @Override
    public List<RacesDTO> getAllRaces() {
        return raceRepository
                .findAll()
                .stream()
                .map(race -> modelMapper.map(race, RacesDTO.class))
                .toList();
    }
}
