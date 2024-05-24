package br.com.fiap.revisaoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.revisaoapi.model.Casa;

@Repository
public interface CasaRepository extends JpaRepository<Casa, Long> {

  Casa findByCep(Long cep);

} 
