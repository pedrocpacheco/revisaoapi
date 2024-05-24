package br.com.fiap.revisaoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.revisaoapi.dto.CasaRequestDto;
import br.com.fiap.revisaoapi.dto.CasaResponseDto;
import br.com.fiap.revisaoapi.model.Casa;
import br.com.fiap.revisaoapi.service.CasaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/casas")
public class CasaController {
  
  @Autowired
  private CasaService service;

  @PostMapping
  public ResponseEntity<Casa> create(@Valid @RequestBody CasaRequestDto dto) {
    return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<CasaResponseDto>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.FOUND);
  }

  @GetMapping("{id}")
  public ResponseEntity<CasaResponseDto> findById(@PathVariable Long id) {
    System.out.println(id);
    return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);
  }

  @PutMapping("{id}")
  public ResponseEntity<Casa> update(@PathVariable Long id, @Valid @RequestBody CasaRequestDto dto) {
    return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
