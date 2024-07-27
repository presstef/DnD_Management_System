package fp.dndmanagementsystem.model.dto;

import java.util.List;

public record MonsterResponseDTO (int count, List<MonsterResponseResultsDTO> results)  {
}
