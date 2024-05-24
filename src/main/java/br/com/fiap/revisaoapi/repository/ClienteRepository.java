package br.com.fiap.revisaoapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.revisaoapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
