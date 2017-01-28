package ua.ppadalka.webstore.security.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.ppadalka.webstore.security.dto.RegistrationForm;

@Component
public class RegistrationFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegistrationForm form = (RegistrationForm) target;
    }
}
