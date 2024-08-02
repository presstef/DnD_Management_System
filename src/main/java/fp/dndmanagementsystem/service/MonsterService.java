package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.monster.MonstersDTO;

import java.util.List;

public interface MonsterService {
    List<String> allAvailableMonsters();
      boolean hasInitializedMonsters();
        //TODO if i can do it with List<T>
    List<MonstersDTO> fetchMonsters();
    void updateMonsters(List<MonstersDTO> monsters);

   // void updateItems(List<ItemsDTO> items);


}
