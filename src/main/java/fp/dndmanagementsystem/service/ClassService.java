package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.dto.characterClass.ClassesDTO;
import fp.dndmanagementsystem.model.dto.monster.MonstersDTO;

import java.util.List;

public interface ClassService {
    boolean hasInitializedClasses();

    List<ClassesDTO> fetchClasses();

    void updateClasses(List<ClassesDTO> classes);

    List<ClassesDTO> getAllClasses();


}
