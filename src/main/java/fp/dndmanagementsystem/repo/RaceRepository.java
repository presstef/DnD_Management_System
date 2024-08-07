package fp.dndmanagementsystem.repo;

import fp.dndmanagementsystem.model.entity.RaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RaceRepository extends JpaRepository<RaceEntity, Long> {
    Optional<RaceEntity> findByName(String name);
}
