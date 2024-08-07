package fp.dndmanagementsystem.model.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import fp.dndmanagementsystem.model.dto.characterClass.ClassesDTO;
import fp.dndmanagementsystem.model.dto.races.RacesDTO;
import org.springframework.stereotype.Service;

@Service
public class CharacterClassMapper {
    public ClassesDTO jsonToClassesDTO(JsonNode json) {
        ClassesDTO classesDTO  = new ClassesDTO();

        classesDTO.setName(json.get("name").asText());
        classesDTO.setHit_die(json.get("hit_die").asInt());

        return classesDTO;
    }
}
