package fp.dndmanagementsystem.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import fp.dndmanagementsystem.config.DnD5eApiConfig;
import fp.dndmanagementsystem.model.dto.item.ItemResponseDTO;
import fp.dndmanagementsystem.model.dto.item.ItemResponseResultsDTO;
import fp.dndmanagementsystem.model.dto.item.ItemsDTO;
import fp.dndmanagementsystem.model.dto.monster.MonstersDTO;
import fp.dndmanagementsystem.model.entity.BaseEntity;
import fp.dndmanagementsystem.model.entity.ItemEntity;
import fp.dndmanagementsystem.model.mapper.ItemMapper;
import fp.dndmanagementsystem.repo.ItemRepository;
import fp.dndmanagementsystem.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ModelMapper modelMapper;
    private final ItemRepository itemRepository;
    private final RestClient restClient;
    private final DnD5eApiConfig dnd5eApiConfig;
    private final ItemMapper itemMapper;

    public ItemServiceImpl(ModelMapper modelMapper, ItemRepository itemRepository, @Qualifier("genericRestClient") RestClient restClient, DnD5eApiConfig dnd5eApiConfig, ItemMapper itemMapper) {
        this.modelMapper = modelMapper;
        this.itemRepository = itemRepository;
        this.restClient = restClient;
        this.dnd5eApiConfig = dnd5eApiConfig;
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ItemEntity> getAllItems() {
        return itemRepository
                .findAll()
                .stream()
                .toList();
    }


    @Override
    public boolean hasInitializedItems() {
        return itemRepository.count() > 0;
    }


    @Override
    public List<ItemsDTO> fetchItems() {
        ItemResponseDTO fetchResponse = restClient
                .get()
                .uri(dnd5eApiConfig.getUrl() + "/equipment")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ItemResponseDTO.class);

        List<ItemsDTO> items = new ArrayList<>();

        for (ItemResponseResultsDTO currItem : fetchResponse.results()) {
            JsonNode fetchStatsResult = restClient
                    .get()
                    .uri(dnd5eApiConfig.getUrl() + "/equipment/" + currItem.index())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(JsonNode.class);

            items.add(itemMapper.jsonToItemsDTO(fetchStatsResult));
        }
        return items;
    }

    @Override
    public void updateItems(List<ItemsDTO> items) {
        if (!items.isEmpty()) {
            //LOGGER.info("Updating {} monsters.", monsters.size());
            items.forEach(itm -> {
                ItemEntity itemEntity = itemRepository.findByName(itm.getName())
                        .orElseGet(ItemEntity::new);

                itemEntity = modelMapper.map(itm, ItemEntity.class);
                itemRepository.save(itemEntity);
            });
        }
        //else  LOGGER.info("Monster DTO is null.");
    }

    @Override
    public List<ItemEntity> findByIds(List<Long> itemIds) {
        return itemRepository.findAllById(itemIds);
    }
}
