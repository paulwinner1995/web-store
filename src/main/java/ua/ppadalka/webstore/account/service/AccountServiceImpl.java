package ua.ppadalka.webstore.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.ppadalka.webstore.account.model.Account;
import ua.ppadalka.webstore.account.model.Role;
import ua.ppadalka.webstore.account.repository.AccountRepository;

import java.time.LocalDateTime;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository repository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(AccountRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.passwordEncoder = encoder;
    }

    @Override
    public Account create(String username, String password, Role role) {
        String encodedPassword = passwordEncoder.encode(password);
        LocalDateTime currentDate = LocalDateTime.now();

        Account account = Account.builder()
                .username(username)
                .password(encodedPassword)
                .role(role)
                .registrationDate(currentDate)
                .version(currentDate)
                .build();

        return repository.save(account);
    }
}
