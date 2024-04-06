package com.avaliacao.azship.infraestrutura.adaptadores.respositories;

import org.springframework.data.domain.Pageable ;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.avaliacao.azship.infraestrutura.adaptadores.entidades.FreteEntity;

@Repository
public interface SpringFreteRepository extends JpaRepository<FreteEntity, Long>{
    @Query(value = "SELECT * FROM frete f WHERE f.destino LIKE %?1%", nativeQuery = true)
	Page<FreteEntity> findAllByOrigem(Pageable pageable, String destino);
}
