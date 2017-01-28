package ua.ppadalka.webstore.security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ppadalka.webstore.security.dto.RegistrationForm;
import ua.ppadalka.webstore.security.service.RegistrationService;
import ua.ppadalka.webstore.security.validation.RegistrationFormValidator;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/registration")
public class RegistrationResource {

    private RegistrationService registrationService;
    private RegistrationFormValidator validator;

    @Autowired
    public RegistrationResource(
            RegistrationService service,
            RegistrationFormValidator validator
    ) {
        this.registrationService = service;
        this.validator = validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @PostMapping
    public ResponseEntity registerCustomer(@Valid @RequestBody RegistrationForm form) {
        registrationService.registerCustomer(form);
        return ResponseEntity.ok().build();
    }
}
