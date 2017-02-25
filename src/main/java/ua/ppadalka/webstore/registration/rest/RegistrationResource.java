package ua.ppadalka.webstore.registration.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ppadalka.webstore.registration.dto.RegistrationForm;
import ua.ppadalka.webstore.registration.service.RegistrationService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/registration")
public class RegistrationResource {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationResource(RegistrationService service) {
        this.registrationService = service;
    }


    @PostMapping
    public ResponseEntity registerCustomer(@Valid @RequestBody RegistrationForm form) {
        registrationService.registerCustomer(form);
        return ResponseEntity.ok().build();
    }
}
