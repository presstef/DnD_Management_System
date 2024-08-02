package fp.dndmanagementsystem.model.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fp.dndmanagementsystem.model.dto.item.ItemsDTO;
import org.springframework.stereotype.Service;

@Service
public class ItemMapper {
    public ItemsDTO jsonToItemsDTO(JsonNode json) {
        ItemsDTO itemsDTO = new ItemsDTO();

        itemsDTO.setName(json.get("name").asText());

        ArrayNode itemDescription = (ArrayNode) json.get("desc");
        if(!itemDescription.isEmpty()) {
            itemsDTO.setDescription(itemDescription.get(0).asText());
        }

        ObjectNode itemEqCategory = (ObjectNode) json.get("equipment_category");
        itemsDTO.setCategory(itemEqCategory.get("name").asText());

        ObjectNode cost = (ObjectNode) json.get("cost");
        String value = cost.get("quantity").asText();
        String currency = cost.get("unit").asText();
        itemsDTO.setCost(value+" "+currency);

        if(json.get("weight") !=null) {
            itemsDTO.setWeight(json.get("weight").asDouble());
        }
        return itemsDTO;
    }
}
