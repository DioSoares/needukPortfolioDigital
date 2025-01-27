package com.needuk.controller;


import com.needuk.dto.VagaDTO;
import com.needuk.model.Vaga;
import com.needuk.service.VagaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/needuk/vagas")
public class VagaController {

    private final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }
    @GetMapping
    public ResponseEntity<List<VagaDTO>> listarVagas() {
        List<Vaga> vagas = vagaService.listarTodas();
        List<VagaDTO> vagasDTO = vagas.stream().map(VagaDTO::new).toList();
        return ResponseEntity.ok(vagasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaDTO> buscarVagaPorId(@PathVariable Long id) {
        Vaga vaga = vagaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
        return ResponseEntity.ok(new VagaDTO(vaga));
    }

    @PostMapping
    public ResponseEntity<VagaDTO> criarVaga(@RequestBody Vaga vaga) {
        Vaga novaVaga = vagaService.salvar(vaga);
        return ResponseEntity.status(HttpStatus.CREATED).body(new VagaDTO(novaVaga));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaga> atualizarVaga(@PathVariable Long id, @RequestBody Vaga vaga) {
        try {
            Vaga vagaAtualizada = vagaService.atualizar(id, vaga);
            return ResponseEntity.ok(vagaAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVaga(@PathVariable Long id) {
        vagaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}