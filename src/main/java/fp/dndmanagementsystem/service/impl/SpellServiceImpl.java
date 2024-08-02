package fp.dndmanagementsystem.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import fp.dndmanagementsystem.config.DnD5eApiConfig;
import fp.dndmanagementsystem.model.dto.spell.SpellResponseDTO;
import fp.dndmanagementsystem.model.dto.spell.SpellResponseResultsDTO;
import fp.dndmanagementsystem.model.dto.spell.SpellsDTO;
import fp.dndmanagementsystem.model.entity.SpellEntity;
import fp.dndmanagementsystem.model.mapper.SpellMapper;
import fp.dndmanagementsystem.repo.SpellRepository;
import fp.dndmanagementsystem.service.SpellService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpellServiceImpl implements SpellService {
    private final ModelMapper modelMapper;
    private final SpellRepository spellRepository;
    private final RestClient restClient;
    private final DnD5eApiConfig dnd5eApiConfig;
    private final SpellMapper spellMapper;

    public SpellServiceImpl(ModelMapper modelMapper, SpellRepository spellRepository, @Qualifier("genericRestClient") RestClient restClient, DnD5eApiConfig dnd5eApiConfig, SpellMapper spellMapper) {
        this.modelMapper = modelMapper;
        this.spellRepository = spellRepository;
        this.restClient = restClient;
        this.dnd5eApiConfig = dnd5eApiConfig;
        this.spellMapper = spellMapper;
    }

    @Override
    public List<String> allAvailableSpells() {
        return spellRepository
                .findAll()
                .stream()
                .map(SpellEntity::getName)
                .toList();
    }

    @Override
    public boolean hasInitializedSpells() {
        return spellRepository.count() > 0;
    }

    @Override
    public  List<SpellsDTO> fetchSpells() {

        SpellResponseDTO fetchedResponse = restClient
                .get()
                .uri(dnd5eApiConfig.getUrl() + "/spells")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(SpellResponseDTO.class);

        List<SpellsDTO>  spells = new ArrayList<>();

        for (SpellResponseResultsDTO currSpell : fetchedResponse.results()){
            JsonNode fetchStatsResult = restClient
                    .get()
                    .uri(dnd5eApiConfig.getUrl() + "/spells/" + currSpell.index())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(JsonNode.class);

          spells.add(spellMapper.jsonToSpellsDTO(fetchStatsResult));
        }
        return spells;
    }

    @Override
    public void updateSpells(List<SpellsDTO> spells) {
        if(!spells.isEmpty()){
            //LOGGER.info("Updating {} monsters.", monsters.size());
            spells.forEach(sp-> {
                SpellEntity spellEntity = spellRepository.findByName(sp.getName())
                        .orElseGet(SpellEntity::new);

                spellEntity = modelMapper.map(sp, SpellEntity.class);
                spellRepository.save(spellEntity);
            });}
        //else  LOGGER.info("Monster DTO is null.");
    }
}
