package ua.ppadalka.webstore.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ppadalka.webstore.account.service.AccountService;
import ua.ppadalka.webstore.profile.service.ProfileService;
import ua.ppadalka.webstore.security.dto.RegistrationForm;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private AccountService accountService;
    private ProfileService profileService;

    @Autowired
    public RegistrationServiceImpl(
            AccountService accountService,
            ProfileService profileService
    ) {
        this.accountService = accountService;
        this.profileService = profileService;
    }

    @Override
    public void registerCustomer(RegistrationForm registrationForm) {}
}
