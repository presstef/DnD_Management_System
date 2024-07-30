package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.SpellsDTO;

import java.util.List;

public interface SpellService {

    List<String> allAvailableSpells();

    boolean hasInitializedSpells();

    List<SpellsDTO> fetchSpells();

    void updateSpells(List<SpellsDTO> spells);
}
