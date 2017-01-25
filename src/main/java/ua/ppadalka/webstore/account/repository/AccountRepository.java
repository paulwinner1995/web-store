package ua.ppadalka.webstore.account.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.ppadalka.webstore.account.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {}
