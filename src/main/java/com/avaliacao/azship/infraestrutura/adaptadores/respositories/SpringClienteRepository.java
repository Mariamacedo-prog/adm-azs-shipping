package com.avaliacao.azship.infraestrutura.adaptadores.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avaliacao.azship.infraestrutura.adaptadores.entidades.ClienteEntity;


@Repository
public interface SpringClienteRepository extends JpaRepository<ClienteEntity, Long>{
}
