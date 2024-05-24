package br.com.fiap.revisaoapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.revisaoapi.dto.CasaRequestDto;
import br.com.fiap.revisaoapi.dto.CasaResponseDto;
import br.com.fiap.revisaoapi.model.Casa;
import br.com.fiap.revisaoapi.repository.CasaRepository;

@Service
public class CasaService {
  
  @Autowired
  private CasaRepository repository;

  public Casa create(CasaRequestDto dto){
    var casa = toEntity(dto);
    return repository.save(casa);
  }

  public List<CasaResponseDto> findAll(){
    var entities = repository.findAll();
    var dtos = entities.stream()
                       .map(CasaService::toResponseDTO)
                       .collect(Collectors.toList());
    return dtos;
  }

  public CasaResponseDto findById(Long id){
    var entity = repository.findById(id).get();
    var dto = toResponseDTO(entity);
    return dto;
  }

  public Casa update(Long id, CasaRequestDto dto){
    var existingCasa = repository.findById(id)
                                 .orElseThrow(() -> new RuntimeException("Casa não encontrada"));

                                 existingCasa.setLogradouro(dto.logradouro());
    existingCasa.setCep(dto.cep());
    existingCasa.setNumero(dto.numero());
    existingCasa.setComplemento(dto.complemento());
    existingCasa.setNumeroQuartos(dto.numeroQuartos());
    existingCasa.setNumeroBanheiros(dto.numeroBanheiros());
    existingCasa.setMetrosQuadrados(dto.metrosQuadrados());

    return repository.save(existingCasa);
  }

  public void delete(Long id){
    var existingCasa = repository.findById(id)
                                 .orElseThrow(() -> new RuntimeException("Casa não encontrada"));
    repository.delete(existingCasa);
  } 

  public static Casa toEntity(CasaRequestDto dto) {
    return new Casa(
      dto.logradouro(),
      dto.cep(),
      dto.numero(),
      dto.complemento(),
      dto.numeroQuartos(),
      dto.numeroBanheiros(),
      dto.metrosQuadrados()
    );
}


  public static CasaResponseDto toResponseDTO(Casa casa) {
    return new CasaResponseDto(
      casa.getId(),
      casa.getLogradouro(),
      casa.getCep(),
      casa.getNumero(),
      casa.getComplemento(),
      casa.getNumeroQuartos(),
      casa.getNumeroBanheiros(),
      casa.getMetrosQuadrados()
    );
  }

}
