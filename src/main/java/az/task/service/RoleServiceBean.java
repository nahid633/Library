package az.task.service;

import az.task.dao.RoleDao;
import az.task.model.Role;
import az.task.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Nahid on 8/31/17.
 */
@Service("roleService")
public class RoleServiceBean implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public Role findByCode(String code) {
        return roleDao.findByCode(code);
    }
}
