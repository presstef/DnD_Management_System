package fp.dndmanagementsystem.repo;

import fp.dndmanagementsystem.model.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
}
