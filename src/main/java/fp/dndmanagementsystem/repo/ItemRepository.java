package fp.dndmanagementsystem.repo;

import fp.dndmanagementsystem.model.entity.ItemEntity;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
    Optional<ItemEntity> findByName(String name);
}
