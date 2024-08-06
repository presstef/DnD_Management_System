package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.monster.MonstersDTO;

import java.util.List;

public interface MonsterService {
    List<MonstersDTO> getAllMonsters();
    boolean hasInitializedMonsters();
    List<MonstersDTO> fetchMonsters();
    void updateMonsters(List<MonstersDTO> monsters);

   // void updateItems(List<ItemsDTO> items);


}
