package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.ItemsDTO;
import fp.dndmanagementsystem.model.dto.MonstersDTO;

import java.util.List;

public interface ItemService {
    List<String> allAvailableItems();
    boolean hasInitializedItems();
    List<ItemsDTO> fetchItems();
    void updateItems(List<ItemsDTO> items);
}
