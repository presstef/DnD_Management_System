package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.MonsterApiDTO;

public interface MonsterService {
    MonsterApiDTO fetchMonsters();
    void updateMonsters(MonsterApiDTO monsterApiDTO);

    boolean hasInitializedMonsters();
}
