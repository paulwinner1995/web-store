package ua.ppadalka.webstore.registration.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

public class RegistrationForm {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String confirmationPassword;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String address;
    @NotBlank
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$")
    private String phoneNumber;

    public RegistrationForm() {}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmationPassword() {
        return confirmationPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
