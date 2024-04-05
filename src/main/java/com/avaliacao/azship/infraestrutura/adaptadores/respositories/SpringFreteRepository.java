package com.avaliacao.azship.infraestrutura.adaptadores.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.azship.infraestrutura.adaptadores.entidades.FreteEntity;

public interface SpringFreteRepository extends JpaRepository<FreteEntity, Long>{
}
