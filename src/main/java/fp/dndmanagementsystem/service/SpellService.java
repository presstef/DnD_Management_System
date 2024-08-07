package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.spell.SpellsDTO;

import java.util.List;

public interface SpellService {

    List<String> getAllSpellNames();

    boolean hasInitializedSpells();

    List<SpellsDTO> fetchSpells();

    void updateSpells(List<SpellsDTO> spells);
}
