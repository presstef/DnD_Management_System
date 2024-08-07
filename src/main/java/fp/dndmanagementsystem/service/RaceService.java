package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.monster.MonstersDTO;
import fp.dndmanagementsystem.model.dto.races.RacesDTO;

import java.util.List;

public interface RaceService {
   // List<String> getAllRacesNames();

    boolean hasInitializedRaces();

    List<RacesDTO> fetchRaces();

    void updateRaces(List<RacesDTO> races);

    List<RacesDTO> getAllRaces();
}
