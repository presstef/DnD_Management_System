package fp.dndmanagementsystem.repo;

import fp.dndmanagementsystem.model.dto.spell.SpellsDTO;
import fp.dndmanagementsystem.model.entity.SpellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpellRepository extends JpaRepository<SpellEntity, Long> {
    List<SpellEntity> findByLevel(int level);

    Optional<SpellEntity> findByName(String name);
}
