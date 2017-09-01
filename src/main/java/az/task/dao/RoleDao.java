package az.task.dao;

import az.task.model.Role;

public interface RoleDao {
    Role findByCode(String code);
}
