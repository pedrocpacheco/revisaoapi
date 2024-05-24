package br.com.fiap.revisaoapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_CASA")
public class Casa {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_casa")
  private Long id;

  @NotBlank(message = "Logradouro não pode estar em branco")
  @Size(max = 255, message = "Logradouro deve ter no máximo 255 caracteres")
  @Column(name = "logradouro_casa")
  private String logradouro;

  @NotNull(message = "CEP não pode ser nulo")
  @Min(value = 10000000, message = "CEP deve ter no mínimo 8 dígitos")
  @Max(value = 99999999, message = "CEP deve ter no máximo 8 dígitos")
  @Column(name = "cep_casa")
  private Long cep;

  @NotNull(message = "Número não pode ser nulo")
  @Min(value = 1, message = "Número deve ser no mínimo 1")
  @Column(name = "numero_casa")
  private Long numero;

  @Size(max = 255, message = "Complemento deve ter no máximo 255 caracteres")
  @Column(name = "complemento_casa")
  private String complemento;

  @NotNull(message = "Número de quartos não pode ser nulo")
  @Min(value = 1, message = "Número de quartos deve ser no mínimo 1")
  @Column(name = "numero_quartos_casa")
  private Long numeroQuartos;

  @NotNull(message = "Número de banheiros não pode ser nulo")
  @Min(value = 1, message = "Número de banheiros deve ser no mínimo 1")
  @Column(name = "numero_banheiros_casa")
  private Long numeroBanheiros;

  @NotBlank(message = "Metros quadrados não pode estar em branco")
  @Pattern(regexp = "\\d+\\.?\\d*", message = "Metros quadrados deve ser um número válido")
  @Column(name = "metros_quadrados_casa")
  private String metrosQuadrados;

  public Casa() {
  }

  public Casa(Long id, String logradouro, Long cep, Long numero, String complemento, Long numeroQuartos,
      Long numeroBanheiros, String metrosQuadrados) {
    this.id = id;
    this.logradouro = logradouro;
    this.cep = cep;
    this.numero = numero;
    this.complemento = complemento;
    this.numeroQuartos = numeroQuartos;
    this.numeroBanheiros = numeroBanheiros;
    this.metrosQuadrados = metrosQuadrados;
  }
 
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public Long getCep() {
    return cep;
  }

  public void setCep(Long cep) {
    this.cep = cep;
  }

  public Long getNumero() {
    return numero;
  }

  public void setNumero(Long numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public Long getNumeroQuartos() {
    return numeroQuartos;
  }

  public void setNumeroQuartos(Long numeroQuartos) {
    this.numeroQuartos = numeroQuartos;
  }

  public Long getNumeroBanheiros() {
    return numeroBanheiros;
  }

  public void setNumeroBanheiros(Long numeroBanheiros) {
    this.numeroBanheiros = numeroBanheiros;
  }

  public String getMetrosQuadrados() {
    return metrosQuadrados;
  }

  public void setMetrosQuadrados(String metrosQuadrados) {
    this.metrosQuadrados = metrosQuadrados;
  }

  

}
