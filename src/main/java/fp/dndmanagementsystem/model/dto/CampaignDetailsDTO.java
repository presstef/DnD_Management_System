package fp.dndmanagementsystem.model.dto;

import fp.dndmanagementsystem.model.entity.CharacterEntity;
import fp.dndmanagementsystem.model.entity.MonsterEntity;
import fp.dndmanagementsystem.model.entity.UserEntity;

import java.util.List;

public record CampaignDetailsDTO(Long id,
                                String name,
                                String description //,
//                                UserEntity dungeonMaster,
////                                List<CharacterEntity> characters,
////                                List<MonsterEntity> monsters
) {
}
