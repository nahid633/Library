package az.task.service.interfaces;

import az.task.model.Account;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface AccountService {
    Account findByEmail(String email);
    void saveUser(Account account);
}
