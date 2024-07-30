package fp.dndmanagementsystem.model.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fp.dndmanagementsystem.model.dto.SpellsDTO;
import org.hibernate.validator.resourceloading.AggregateResourceBundleLocator;
import org.springframework.stereotype.Service;

@Service
public class SpellMapper {
    public SpellsDTO jsonToSpellsDTO(JsonNode json) {
        SpellsDTO spellsDTO = new SpellsDTO();
        spellsDTO.setName(json.get("name").asText());
        ArrayNode spellDescription = (ArrayNode) json.get("desc");
        spellsDTO.setDescription(spellDescription.get(0).asText());
        spellsDTO.setLevel(json.get("level").asInt());
        spellsDTO.setCasting_time(json.get("casting_time").asText());
        if(json.get("attack_type") != null)
            spellsDTO.setAttack_type(json.get("attack_type").asText());
        spellsDTO.setConcentration(json.get("concentration").asBoolean());
        return spellsDTO;
    }
}
