package fp.dndmanagementsystem.repo;

import fp.dndmanagementsystem.model.entity.CharacterEntity;
import fp.dndmanagementsystem.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
    List<CharacterEntity> getAllByUser(UserEntity user);
}
