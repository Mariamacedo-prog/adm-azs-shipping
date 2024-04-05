package com.avaliacao.azship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.avaliacao.azship.infraestrutura.adaptadores.respositories.SpringClienteRepository;
import com.avaliacao.azship.infraestrutura.adaptadores.respositories.SpringFreteRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses =  {SpringFreteRepository.class, SpringClienteRepository.class})
public class AzshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzshipApplication.class, args);
	}

}
