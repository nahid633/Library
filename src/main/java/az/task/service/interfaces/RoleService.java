package az.task.service.interfaces;

import az.task.model.Role;

/**
 * Created by Nahid on 8/31/17.
 */
public interface RoleService {
    Role findByCode(String code);

}
