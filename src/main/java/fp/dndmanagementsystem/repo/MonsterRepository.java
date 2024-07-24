package fp.dndmanagementsystem.repo;

import fp.dndmanagementsystem.model.entity.MonsterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonsterRepository extends JpaRepository<MonsterEntity, Long> {
    Optional<MonsterEntity> findByName(String name);
}
