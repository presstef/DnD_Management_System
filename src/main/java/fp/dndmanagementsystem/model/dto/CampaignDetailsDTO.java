package fp.dndmanagementsystem.model.dto;

import fp.dndmanagementsystem.model.entity.CharacterEntity;
import fp.dndmanagementsystem.model.entity.MonsterEntity;
import fp.dndmanagementsystem.model.entity.UserEntity;

import java.util.Set;

public record CampaignDetailsDTO(Long id,
                                String name,
                                String description,
                                UserEntity dungeonMaster,
                                Set<CharacterEntity> characters,
                                Set<MonsterEntity> monsters) {
}
