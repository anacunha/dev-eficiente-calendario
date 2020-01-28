package br.com.deveficiente.calendario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class CalendarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalendarioApplication.class, args);
	}

}
