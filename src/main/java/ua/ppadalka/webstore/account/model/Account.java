package ua.ppadalka.webstore.account.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT")
@SequenceGenerator(
        name = "ACCOUNT_ID_SEQUENCE_GENERATOR",
        sequenceName = "ACCOUNT_ID_SEQUENCE",
        allocationSize = 1
)
public class Account implements UserDetails, Serializable {

    @Id
    @GeneratedValue(
            generator = "ACCOUNT_ID_SEQUENCE_GENERATOR",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @Column(
            name = "USERNAME",
            unique = true,
            nullable = false
    )
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ROLE", nullable = false)
    private Role role;

    @Column(name = "REGISTRATION_DATE", nullable = false)
    private LocalDateTime registrationDate;

    @Column(name = "VERSION", nullable = false)
    private LocalDateTime version;

    public Account(
            String username,
            String password,
            Role role,
            LocalDateTime registrationDate)
    {
        this.username = username;
        this.password = password;
        this.role = role;
        this.registrationDate = registrationDate;
        this.version = registrationDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role, registrationDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Account)) return false;

        Account account = (Account) obj;

        return Objects.equals(username, account.username) &&
                Objects.equals(role, account.role) &&
                Objects.equals(registrationDate, account.registrationDate);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public LocalDateTime getVersion() {
        return version;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
