package fp.dndmanagementsystem.repo;

import fp.dndmanagementsystem.model.entity.SpellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpellRepository extends JpaRepository<SpellEntity, Long> {
    Optional<SpellEntity> findByName(String name);
}
