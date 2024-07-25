package fp.dndmanagementsystem.service.impl;

import fp.dndmanagementsystem.config.ApiConfig;
import fp.dndmanagementsystem.model.dto.MonsterApiDTO;
import fp.dndmanagementsystem.model.entity.MonsterEntity;
import fp.dndmanagementsystem.repo.MonsterRepository;
import fp.dndmanagementsystem.service.MonsterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MonsterServiceImpl implements MonsterService {
    private final Logger LOGGER = LoggerFactory.getLogger(MonsterServiceImpl.class);
    private final MonsterRepository monsterRepository;
    private final RestClient restClient;
    private final ApiConfig apiConfig;

    public MonsterServiceImpl(MonsterRepository monsterRepository, RestClient restClient, ApiConfig apiConfig) {
        this.monsterRepository = monsterRepository;
        this.restClient = restClient;
        this.apiConfig = apiConfig;
    }

    @Override
    public boolean hasInitializedMonsters() {
        return monsterRepository.count() > 0;
    }

    @Override
    public MonsterApiDTO fetchMonsters() {
        String url = this.apiConfig.getUrl() + "monsters/?name=";

        return restClient
                .get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(MonsterApiDTO.class);
    }

    @Override
    public void updateMonsters(MonsterApiDTO monsterApiDTO) {
       LOGGER.info("Updating {} rates.", monsterApiDTO.names().size());

        for (String name : monsterApiDTO.names()){
            if(monsterRepository.findByName(name).isEmpty()){
                MonsterEntity newMonsterEntity = new MonsterEntity();
                newMonsterEntity.setName(name);
                monsterRepository.save(newMonsterEntity);
            }
        }
    }


}
