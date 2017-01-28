package ua.ppadalka.webstore.security.service;

import ua.ppadalka.webstore.security.dto.RegistrationForm;

public interface RegistrationService {

    void registerCustomer(RegistrationForm registrationForm);
}
