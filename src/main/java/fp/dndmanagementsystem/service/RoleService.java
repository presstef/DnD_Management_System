package fp.dndmanagementsystem.service;

import fp.dndmanagementsystem.model.entity.Role;

public interface RoleService {
    Role getAdminRole();
    Role getUserRole();
}
