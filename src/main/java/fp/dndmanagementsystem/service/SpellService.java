package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.spell.SpellsDTO;
import fp.dndmanagementsystem.model.entity.SpellEntity;

import java.util.List;

public interface SpellService {

     List<SpellEntity> getAllSpells() ;

     List<SpellEntity> getSpellsByLevel(int level);

    boolean hasInitializedSpells();

    List<SpellsDTO> fetchSpells();

    void updateSpells(List<SpellsDTO> spells);
}
