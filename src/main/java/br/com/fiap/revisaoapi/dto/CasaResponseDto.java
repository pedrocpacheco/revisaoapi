package br.com.fiap.revisaoapi.dto;

public record CasaResponseDto(
  Long id,
  String logradouro,
  Long cep,
  Long numero,
  String complemento,
  Long numeroQuartos,
  Long numeroBanheiros,
  String metrosQuadrados
) {}
