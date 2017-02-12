package ua.ppadalka.webstore.account.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.ppadalka.webstore.account.model.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    /**
     * Looks for account by given username
     *
     * @param username - username for search account by
     * @return - {@link Optional} of {@link Account} if account exists
     *           or {@link Optional} otherwise
     */
    Optional<Account> findByUsername(String username);
}
