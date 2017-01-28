package ua.ppadalka.webstore.security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ppadalka.webstore.security.dto.RegistrationForm;
import ua.ppadalka.webstore.security.service.RegistrationService;

@RestController
@RequestMapping(path = "/registration")
public class RegistrationResource {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationResource(RegistrationService service) {
        this.registrationService = service;
    }

    @PostMapping
    public ResponseEntity registerCustomer(@RequestBody RegistrationForm form) {
        registrationService.registerCustomer(form);
        return ResponseEntity.ok().build();
    }
}
