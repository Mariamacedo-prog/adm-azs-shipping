package com.avaliacao.azship.infraestrutura.adaptadores.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avaliacao.azship.infraestrutura.adaptadores.entidades.AtributoClienteEntity;

@Repository
public interface SpringAtributoClienteRepository extends JpaRepository<AtributoClienteEntity, Long>{

}
