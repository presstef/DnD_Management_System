package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.MonstersDTO;

import java.util.List;

public interface MonsterService {
    List<String> allAvailableMonsters();
    boolean hasInitializedMonsters();

    List<MonstersDTO> fetchMonsters();

    void updateMonsters(List<MonstersDTO> monsters);

    //Optional<String> findMonster(String name);

}
