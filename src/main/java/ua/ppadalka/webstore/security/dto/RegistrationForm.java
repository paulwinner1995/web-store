package ua.ppadalka.webstore.security.dto;

public class RegistrationForm {
    private String username;
    private String password;
    private String confirmationPassword;

    private String firstName;
    private String lastName;
    private String address;
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
