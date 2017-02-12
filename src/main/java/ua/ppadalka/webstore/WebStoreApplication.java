package ua.ppadalka.webstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

@SpringBootApplication
public class WebStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebStoreApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {

			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return Objects.equals(rawPassword.toString(), encodedPassword);
			}
		};
	}
}
