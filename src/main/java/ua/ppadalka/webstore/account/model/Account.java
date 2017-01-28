package ua.ppadalka.webstore.account.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.ppadalka.webstore.common.converter.LocalDateTimeConverter;
import ua.ppadalka.webstore.common.util.OptionalUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

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

    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name = "REGISTRATION_DATE", nullable = false)
    private LocalDateTime registrationDate;

    @Column(name = "VERSION", nullable = false)
    private LocalDateTime version;

    public Account() {}

    public static AccountBuilder builder() {
        return new AccountBuilder();
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

    public static class AccountBuilder {
        private String username;
        private String password;
        private Role role;
        private LocalDateTime registrationDate;
        private LocalDateTime version;

        private AccountBuilder() {}

        public Account build() {
            Account account = new Account();

            account.username = OptionalUtils.orElseDefault(username, account.username);
            account.password = OptionalUtils.orElseDefault(password, account.password);
            account.role = OptionalUtils.orElseDefault(role, account.role);
            account.registrationDate = OptionalUtils
                    .orElseDefault(registrationDate, account.registrationDate);
            account.version = OptionalUtils.orElseDefault(version, account.version);

            return account;
        }

        public AccountBuilder username(String username) {
            this.username = username;
            return this;
        }

        public AccountBuilder password(String password) {
            this.password = password;
            return this;
        }

        public AccountBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public AccountBuilder registrationDate(LocalDateTime registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public AccountBuilder version(LocalDateTime version) {
            this.version = version;
            return this;
        }
    }
}
