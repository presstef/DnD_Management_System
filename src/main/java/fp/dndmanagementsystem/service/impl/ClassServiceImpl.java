package fp.dndmanagementsystem.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import fp.dndmanagementsystem.config.DnD5eApiConfig;
import fp.dndmanagementsystem.model.dto.characterClass.ClassResponseDTO;
import fp.dndmanagementsystem.model.dto.characterClass.ClassResponseResultsDTO;
import fp.dndmanagementsystem.model.dto.characterClass.ClassesDTO;
import fp.dndmanagementsystem.model.dto.monster.MonstersDTO;
import fp.dndmanagementsystem.model.dto.races.RacesDTO;
import fp.dndmanagementsystem.model.dto.races.RaceResponseDTO;
import fp.dndmanagementsystem.model.entity.ClassEntity;
import fp.dndmanagementsystem.model.entity.RaceEntity;
import fp.dndmanagementsystem.model.mapper.CharacterClassMapper;
import fp.dndmanagementsystem.model.mapper.RaceMapper;
import fp.dndmanagementsystem.repo.ClassRepository;
import fp.dndmanagementsystem.service.ClassService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;
    private final RestClient restClient;
    private final DnD5eApiConfig dnd5eApiConfig;
    private final CharacterClassMapper characterClassMapper;
    private final ModelMapper modelMapper;

    public ClassServiceImpl(ClassRepository classRepository, @Qualifier("genericRestClient") RestClient restClient, DnD5eApiConfig dnd5eApiConfig, CharacterClassMapper characterClassMapper, ModelMapper modelMapper) {
        this.classRepository = classRepository;
        this.restClient = restClient;
        this.dnd5eApiConfig = dnd5eApiConfig;
        this.characterClassMapper = characterClassMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean hasInitializedClasses() {
        return classRepository.count()>0;
    }

    @Override
    public List<ClassesDTO> fetchClasses() {
        ClassResponseDTO fetchedResponse = restClient
                .get()
                .uri(dnd5eApiConfig.getUrl() + "/classes")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ClassResponseDTO.class);

        List<ClassesDTO>  characterClasses = new ArrayList<>();

        for (ClassResponseResultsDTO currClass : fetchedResponse.results()){
            JsonNode fetchStatsResult = restClient
                    .get()
                    .uri(dnd5eApiConfig.getUrl() + "/classes/" + currClass.index())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(JsonNode.class);

            characterClasses.add(characterClassMapper.jsonToClassesDTO(fetchStatsResult));
        }
        return characterClasses;
    }

    @Override
    public void updateClasses(List<ClassesDTO> classes) {
        if(!classes.isEmpty()){
            classes.forEach(cl-> {
                ClassEntity classEntity = classRepository.findByName(cl.getName())
                        .orElseGet(ClassEntity::new);

                classEntity = modelMapper.map(cl, ClassEntity.class);
                classRepository.save(classEntity);
            });}
    }

    @Override
    public List<ClassesDTO> getAllClasses() {
        return classRepository
                .findAll()
                .stream()
                .map(cl -> modelMapper.map(cl, ClassesDTO.class))
                .toList();
    }
}
