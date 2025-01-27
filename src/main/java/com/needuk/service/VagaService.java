package com.needuk.service;

import com.needuk.model.Vaga;
import com.needuk.repository.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VagaService {

    private final VagaRepository vagaRepository;

    public VagaService(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    public List<Vaga> listarTodas() {
        return vagaRepository.findAll();
    }

    public Optional<Vaga> buscarPorId(Long id) {
        return vagaRepository.findById(id);
    }

    public Vaga salvar(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    public Vaga atualizar(Long id, Vaga vagaAtualizada) {
        Optional<Vaga> vagaExistente = vagaRepository.findById(id);
        if (vagaExistente.isPresent()) {
            Vaga vaga = vagaExistente.get();
            vaga.setTitulo(vagaAtualizada.getTitulo());
            vaga.setDescricao(vagaAtualizada.getDescricao());
            vaga.setRequisitos(vagaAtualizada.getRequisitos());
            return vagaRepository.save(vaga);
        } else {
            throw new RuntimeException("Vaga não encontrada.");
        }
    }

    public void deletar(Long id) {
        vagaRepository.deleteById(id);
    }
}