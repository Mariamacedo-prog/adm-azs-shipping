package com.avaliacao.azship.infraestrutura.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.avaliacao.azship.dominio.adaptadores.services.AtributoClienteServiceImp;
import com.avaliacao.azship.dominio.adaptadores.services.ClienteServiceImp;
import com.avaliacao.azship.dominio.adaptadores.services.FreteServiceImp;
import com.avaliacao.azship.dominio.portas.interfaces.AtributoClienteServicePort;
import com.avaliacao.azship.dominio.portas.interfaces.ClienteServicePort;
import com.avaliacao.azship.dominio.portas.interfaces.FreteServicePort;
import com.avaliacao.azship.dominio.portas.repositories.AtributoClienteRepositoryPort;
import com.avaliacao.azship.dominio.portas.repositories.ClienteRepositroyPort;
import com.avaliacao.azship.dominio.portas.repositories.FreteRepositoryPort;


@Configuration
public class BeanConfiguracao {
    @Bean
    FreteServicePort freteService(FreteRepositoryPort freteRepositoryPort) {
        return new FreteServiceImp(freteRepositoryPort);
    }
    
    @Bean
    ClienteServicePort clienteService(ClienteRepositroyPort clienteServicePort) {
        return new ClienteServiceImp(clienteServicePort);
    }
    
    @Bean
    AtributoClienteServicePort atributoClienteService(AtributoClienteRepositoryPort atributoClienteServicePort) {
        return new AtributoClienteServiceImp(atributoClienteServicePort);
    }
}
