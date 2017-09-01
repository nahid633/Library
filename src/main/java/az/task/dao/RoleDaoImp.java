package az.task.dao;

import az.task.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public class RoleDaoImp implements RoleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Role findByCode(String code) {
        String query = "SELECT * from roles WHERE code = ?";
        return jdbcTemplate.queryForObject(query,new Object[] { code },new BeanPropertyRowMapper<>(Role.class));
    }
}
