package com.api.controleestacionamento.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class VagaEstacionamentoDto {
	
	@NotBlank
    private String numeroVaga;
    @NotBlank
    @Size(max = 7)
    private String placaDoVeiculo;
    @NotBlank
    private String marcaVeiculo;
    @NotBlank
    private String modeloVeiculo;
    @NotBlank
    private String corVeiculo;
    @NotBlank
    private String nomeResponsavel;
    @NotBlank
    private String apartamento;
    @NotBlank
    private String bloco;
	public String getNumeroVaga() {
		return numeroVaga;
	}
	public void setNumeroVaga(String numeroVaga) {
		this.numeroVaga = numeroVaga;
	}
	public String getPlacaDoVeiculo() {
		return placaDoVeiculo;
	}
	public void setPlacaDoVeiculo(String placaDoVeiculo) {
		this.placaDoVeiculo = placaDoVeiculo;
	}
	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}
	public void setMarcaVeiculo(String marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
	}
	public String getModeloVeiculo() {
		return modeloVeiculo;
	}
	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}
	public String getCorVeiculo() {
		return corVeiculo;
	}
	public void setCorVeiculo(String corVeiculo) {
		this.corVeiculo = corVeiculo;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public String getApartamento() {
		return apartamento;
	}
	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
    
    
}
