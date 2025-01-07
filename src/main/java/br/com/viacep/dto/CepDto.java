package br.com.viacep.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonPropertyOrder({"cep", "logradouro", "complemento", "unidade", "bairro", "localidade", "uf", "estado", "regiao", "ibge", "gia", "ddd", "siafi"})
public class CepDto {
    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}