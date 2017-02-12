package ua.ppadalka.webstore.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.ppadalka.webstore.account.model.Account;
import ua.ppadalka.webstore.account.service.AccountService;
import ua.ppadalka.webstore.profile.dto.ProfileDTO;
import ua.ppadalka.webstore.profile.service.ProfileService;
import ua.ppadalka.webstore.registration.dto.RegistrationForm;

import static ua.ppadalka.webstore.account.model.Role.CUSTOMER;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private AccountService accountService;
    private ProfileService profileService;

    @Autowired
    public RegistrationServiceImpl(AccountService accountService,
                                   ProfileService profileService) {
        this.accountService = accountService;
        this.profileService = profileService;
    }

    @Transactional
    @Override
    public void registerCustomer(RegistrationForm registrationForm) {
        String username = registrationForm.getUsername();
        String password = registrationForm.getPassword();

        Account account = accountService.create(username, password, CUSTOMER);

        String firstName = registrationForm.getFirstName();
        String lastName = registrationForm.getLastName();
        String address = registrationForm.getAddress();
        String phoneNumber = registrationForm.getPhoneNumber();

        ProfileDTO profileDTO = ProfileDTO.builder()
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .phoneNumber(phoneNumber)
                .build();

        profileService.create(profileDTO, account);
    }
}
