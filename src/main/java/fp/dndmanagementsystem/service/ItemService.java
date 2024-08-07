package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.item.ItemsDTO;
import fp.dndmanagementsystem.model.entity.ItemEntity;

import java.util.List;

public interface ItemService {
    List<ItemEntity> getAllItems();
    boolean hasInitializedItems();
    List<ItemsDTO> fetchItems();
    void updateItems(List<ItemsDTO> items);

    List<ItemEntity> findByIds(List<Long> itemIds);
}
