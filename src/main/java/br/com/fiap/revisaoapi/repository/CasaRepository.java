package br.com.fiap.revisaoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.revisaoapi.model.Casa;

public interface CasaRepository extends JpaRepository<Casa, Long> {

  Casa findByCep(Long cep);

} 
