package fp.dndmanagementsystem.service.impl;


import fp.dndmanagementsystem.config.DnD5eApiConfig;
import fp.dndmanagementsystem.model.dto.MonsterResponseDTO;
import fp.dndmanagementsystem.model.dto.MonsterResponseResultsDTO;
import fp.dndmanagementsystem.model.dto.MonstersDTO;

import fp.dndmanagementsystem.model.entity.MonsterEntity;
import fp.dndmanagementsystem.repo.MonsterRepository;
import fp.dndmanagementsystem.service.MonsterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;


@Service
public class MonsterServiceImpl implements MonsterService {
    //TODO logger needed??
  //  private final Logger LOGGER = LoggerFactory.getLogger(MonsterServiceImpl.class);
    private final MonsterRepository monsterRepository;
    private final RestClient restClient;
    private final DnD5eApiConfig dnd5eApiConfig;

    public MonsterServiceImpl(MonsterRepository monsterRepository, RestClient restClient, DnD5eApiConfig dnd5eApiConfig) {
        this.monsterRepository = monsterRepository;
        this.restClient = restClient;
        this.dnd5eApiConfig = dnd5eApiConfig;
    }

    @Override
    public List<String> allAvailableMonsters() {
        return monsterRepository
                .findAll()
                .stream()
                .map(MonsterEntity::getName)
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
           MonstersDTO newMonster = new MonstersDTO(currMonster.name());
           monsters.add(newMonster);
       }
       return monsters;
    }

    //TODO
    @Override
    public void updateMonsters(List<MonstersDTO> monsters) {
        if(!monsters.isEmpty()){
        //LOGGER.info("Updating {} monsters.", monsters.size());

        monsters.forEach(monstr-> {
            var monsterEntity = monsterRepository.findByName(monstr.name())
                    .orElseGet(MonsterEntity::new);

            monsterEntity.setName(monstr.name());

            monsterRepository.save(monsterEntity);
        });}
        //else  LOGGER.info("Monster DTO is null.");
    }
}
