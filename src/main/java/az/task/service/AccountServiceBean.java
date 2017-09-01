package az.task.service;

import az.task.dao.AccountDao;
import az.task.model.Account;
import az.task.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
public class AccountServiceBean implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findByEmail(String email) {
        return accountDao.findByEmail(email);
    }
    /**
     * Encoding in BCryptPasswordEncoder
     * */
    @Bean
    public  PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void saveUser(Account account) {
        account.setPassword(getPasswordEncoder().encode(account.getPassword()));
        accountDao.saveUser(account);
    }
}
