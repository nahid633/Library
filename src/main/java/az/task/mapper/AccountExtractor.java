package az.task.mapper;

import az.task.model.Account;
import az.task.model.Role;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Mapper for extracting join from db. in our example.it is account and role table join.
 * */
public class AccountExtractor implements ResultSetExtractor<Account>{
    @Override
    public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
        Account account= null;
        while (rs.next()) {
            Long id = rs.getLong("account_id");
            if(account == null){
                String email = rs.getString("email");
                String firstName = rs.getString("first_name");
                String lastName= rs.getString("last_name");
                String password= rs.getString("password");
                account = new Account(id,email,firstName,lastName,password);
                Role role= new Role(rs.getLong("role_id"),rs.getString("code"), rs.getString("label"));
                account.setRole(role);
                return account;
            }
        }
        return null;
    }
    }
