package fp.dndmanagementsystem.model.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import fp.dndmanagementsystem.model.dto.races.RacesDTO;
import org.springframework.stereotype.Service;

@Service
public class RaceMapper {
    public RacesDTO jsonToRacesDTO(JsonNode json) {
        RacesDTO racesDTO  = new RacesDTO();

        racesDTO.setName(json.get("name").asText());
        racesDTO.setAlignment(json.get("alignment").asText());
        racesDTO.setSize_description(json.get("size_description").asText());
        racesDTO.setAge(json.get("age").asText());
        if(json.get("language_desc") != null)
            racesDTO.setLanguage_desc(json.get("language_desc").asText());

        return racesDTO;
    }
}
