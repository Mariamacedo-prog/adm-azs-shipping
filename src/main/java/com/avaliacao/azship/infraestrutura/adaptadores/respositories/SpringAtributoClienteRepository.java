package com.avaliacao.azship.infraestrutura.adaptadores.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.avaliacao.azship.infraestrutura.adaptadores.entidades.AtributoClienteEntity;

@Repository
public interface SpringAtributoClienteRepository extends JpaRepository<AtributoClienteEntity, Long>{
	@Query(value = "select * from atributo_cliente a where a.cliente_id = ?1", nativeQuery = true)
	List<AtributoClienteEntity> findByClienteId(Long clienteId);
}
