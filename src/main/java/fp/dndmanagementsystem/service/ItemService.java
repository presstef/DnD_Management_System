package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.item.ItemsDTO;

import java.util.List;

public interface ItemService {
    List<String> allAvailableItems();
    boolean hasInitializedItems();
    List<ItemsDTO> fetchItems();
    void updateItems(List<ItemsDTO> items);
}
