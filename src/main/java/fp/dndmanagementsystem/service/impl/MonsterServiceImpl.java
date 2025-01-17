package fp.dndmanagementsystem.service.impl;


import fp.dndmanagementsystem.config.DnD5eApiConfig;

import fp.dndmanagementsystem.model.dto.monster.MonsterResponseDTO;
import fp.dndmanagementsystem.model.dto.monster.MonsterResponseResultsDTO;
import fp.dndmanagementsystem.model.dto.monster.MonstersDTO;
import fp.dndmanagementsystem.model.entity.BaseEntity;
import fp.dndmanagementsystem.model.entity.MonsterEntity;
import fp.dndmanagementsystem.repo.MonsterRepository;
import fp.dndmanagementsystem.service.MonsterService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;


@Service
public class MonsterServiceImpl implements MonsterService {
    private final ModelMapper modelMapper;
    private final MonsterRepository monsterRepository;
    private final RestClient restClient;
    private final DnD5eApiConfig dnd5eApiConfig;

    public MonsterServiceImpl(ModelMapper modelMapper, MonsterRepository monsterRepository, @Qualifier("genericRestClient") RestClient restClient, DnD5eApiConfig dnd5eApiConfig) {
        this.modelMapper = modelMapper;
        this.monsterRepository = monsterRepository;
        this.restClient = restClient;
        this.dnd5eApiConfig = dnd5eApiConfig;
    }

    @Override
    public List<MonstersDTO> getAllMonsters() {
        return monsterRepository
                .findAll()
                .stream()
                .map(monster -> modelMapper.map(monster, MonstersDTO.class))
                .toList();
    }

    @Override
    public boolean hasInitializedMonsters() {
        return monsterRepository.count() > 0;
    }

    @Override
    public  List<MonstersDTO> fetchMonsters() {
        MonsterResponseDTO fetchResponse = restClient
                .get()
                .uri(dnd5eApiConfig.getUrl() + "/monsters")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(MonsterResponseDTO.class);

       List<MonstersDTO>  monsters = new ArrayList<>();

       for (MonsterResponseResultsDTO currMonster : fetchResponse.results()){
           MonstersDTO fetchStatsResult = restClient
                   .get()
                   .uri(dnd5eApiConfig.getUrl() + "/monsters/" + currMonster.index())
                   .accept(MediaType.APPLICATION_JSON)
                   .retrieve()
                   .body(MonstersDTO.class);
           if(fetchStatsResult.getImage() != null)
               fetchStatsResult.setImage("https://www.dnd5eapi.co" + fetchStatsResult.getImage());
           monsters.add(fetchStatsResult);
       }
       return monsters;
    }

    @Override
    public void updateMonsters(List<MonstersDTO> monsters) {
        if(!monsters.isEmpty()){
        //LOGGER.info("Updating {} monsters.", monsters.size());
        monsters.forEach(monstr-> {
            MonsterEntity monsterEntity = monsterRepository.findByName(monstr.getName())
                    .orElseGet(MonsterEntity::new);

           monsterEntity = modelMapper.map(monstr, MonsterEntity.class);
            monsterRepository.save(monsterEntity);
        });}
        //else  LOGGER.info("Monster DTO is null.");
    }


}
