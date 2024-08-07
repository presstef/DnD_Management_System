package fp.dndmanagementsystem.model.dto.characterClass;

import fp.dndmanagementsystem.model.dto.spell.SpellResponseResultsDTO;

import java.util.List;

public record ClassResponseDTO (List<ClassResponseResultsDTO> results){
}
