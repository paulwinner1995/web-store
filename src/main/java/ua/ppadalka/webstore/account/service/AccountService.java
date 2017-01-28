package ua.ppadalka.webstore.account.service;

import ua.ppadalka.webstore.account.model.Account;
import ua.ppadalka.webstore.account.model.Role;

public interface AccountService {

    /**
     * Creates account with given username, password and role
     *
     * @param username - username for new account
     * @param password - raw password for new account (password will be encoded)
     * @param role     - role for new account
     *
     * @return - created account
     */
    Account create(String username, String password, Role role);
}
