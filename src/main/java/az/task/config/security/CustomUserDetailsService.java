package az.task.config.security;

import az.task.dao.AccountDao;
import az.task.model.Account;
import az.task.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private final AccountDao userRepository;


    public CustomUserDetailsService(AccountDao userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Account account = userRepository.findByEmail(email);

        if (account == null) {
            // Not found...
            throw new UsernameNotFoundException(
                    "User " + email + " not found.");
        }

        if (account.getRole() == null) {
            // No Roles assigned to user...
            throw new UsernameNotFoundException("User not authorized.");
        }


        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        Role role = account.getRole();
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getCode()));

        User userDetails = new User(account.getEmail(),
                account.getPassword(), true,
                true,true,
                true, grantedAuthorities);

        return userDetails;
    }
}
