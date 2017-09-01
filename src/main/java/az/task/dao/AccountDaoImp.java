package az.task.dao;
import az.task.mapper.AccountExtractor;
import az.task.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImp implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Account findByEmail(String email) {
        String sql ="select * from accounts a natural join roles r WHERE  a.email = ? ";
       return  jdbcTemplate.query(sql,new Object[] { email },new AccountExtractor());
    }
    @Override
    public void saveUser(Account account) {
        String sql = "INSERT INTO accounts " +
                "(email, first_name,last_name,password,role_id) VALUES (?, ?, ? ,?,?)";
        jdbcTemplate.update(sql,new Object[] {
                account.getEmail(),
                account.getFirstName(),
                account.getLastName(),
                account.getPassword(),
                account.getRole().getRoleId()});
    }
}
