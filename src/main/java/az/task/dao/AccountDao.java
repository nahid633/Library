package az.task.dao;

import az.task.model.Account;
public interface AccountDao {
    Account findByEmail(String email);
    void saveUser(Account account);
}
