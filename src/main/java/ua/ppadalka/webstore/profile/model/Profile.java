package ua.ppadalka.webstore.profile.model;

import ua.ppadalka.webstore.account.model.Account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PROFILE")
@SequenceGenerator(
        name = "PROFILE_ID_SEQUENCE_GENERATOR",
        sequenceName = "PROFILE_ID_SEQUENCE",
        allocationSize = 1
)
public class Profile implements Serializable {

    @Id
    @GeneratedValue(
            generator = "PROFILE_ID_SEQUENCE_GENERATOR",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "PROFILE_ID")
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(
            name = "ACCOUNT_ID",
            referencedColumnName = "ACCOUNT_ID"
    )
    private Account account;

    public Profile () {}

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, account);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Profile)) return false;

        Profile profile = (Profile) obj;

        return Objects.equals(firstName, profile.firstName) &&
                Objects.equals(lastName, profile.lastName) &&
                Objects.equals(account, profile.account);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
