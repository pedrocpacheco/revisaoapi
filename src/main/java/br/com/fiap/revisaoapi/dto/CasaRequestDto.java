package br.com.fiap.revisaoapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CasaRequestDto(
  @NotBlank(message = "Logradouro não pode estar em branco")
  @Size(max = 255, message = "Logradouro deve ter no máximo 255 caracteres")
  String logradouro,

  @NotNull(message = "CEP não pode ser nulo")
  @Min(value = 10000000, message = "CEP deve ter no mínimo 8 dígitos")
  @Max(value = 99999999, message = "CEP deve ter no máximo 8 dígitos")
  Long cep,

  @NotNull(message = "Número não pode ser nulo")
  @Min(value = 1, message = "Número deve ser no mínimo 1")
  Long numero,

  @Size(max = 255, message = "Complemento deve ter no máximo 255 caracteres")
  String complemento,

  @NotNull(message = "Número de quartos não pode ser nulo")
  @Min(value = 1, message = "Número de quartos deve ser no mínimo 1")
  Long numeroQuartos,

  @NotNull(message = "Número de banheiros não pode ser nulo")
  @Min(value = 1, message = "Número de banheiros deve ser no mínimo 1")
  Long numeroBanheiros,

  @NotBlank(message = "Metros quadrados não pode estar em branco")
  @Pattern(regexp = "\\d+\\.?\\d*", message = "Metros quadrados deve ser um número válido")
  String metrosQuadrados
) {}

