package com.api.controleestacionamento.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.controleestacionamento.models.VagaEstacionamentoModel;
import com.api.controleestacionamento.repositories.VagaEstacionamentoRepository;

@Service
public class VagaEstacionamentoService {
	
	final VagaEstacionamentoRepository vagaEstacionamentoRepository;
	
	public VagaEstacionamentoService(VagaEstacionamentoRepository vagaEstacionamentoRepository) {
		this.vagaEstacionamentoRepository = vagaEstacionamentoRepository;
	}

	@Transactional
	public VagaEstacionamentoModel save(VagaEstacionamentoModel vagaEstacionamentoModel) {
		return vagaEstacionamentoRepository.save(vagaEstacionamentoModel);
	}
	
	public List<VagaEstacionamentoModel> findAll() {
		return vagaEstacionamentoRepository.findAll();
	}

	public Optional<VagaEstacionamentoModel> findById(UUID id) {
		return vagaEstacionamentoRepository.findById(id);
	}

	@Transactional
	public void delete(VagaEstacionamentoModel vagaEstacionamentoModel) {
		vagaEstacionamentoRepository.delete(vagaEstacionamentoModel);
	}

}