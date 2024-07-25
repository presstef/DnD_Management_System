package fp.dndmanagementsystem.repo;

import fp.dndmanagementsystem.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<Role, Long> {
}
