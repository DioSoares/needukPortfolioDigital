package com.needuk.controller;

import com.needuk.dto.PortfolioDTO;
import com.needuk.model.Portfolio;
import com.needuk.service.PortfolioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/needuk/portfolios")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping
    public ResponseEntity<List<PortfolioDTO>> listarPortfolios() {
        List<Portfolio> portfolios = portfolioService.listarTodos();
        List<PortfolioDTO> portfoliosDTO = portfolios.stream().map(PortfolioDTO::new).toList();
        return ResponseEntity.ok(portfoliosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioDTO> buscarPortfolioPorId(@PathVariable Long id) {
        Portfolio portfolio = portfolioService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Portfólio não encontrado"));
        return ResponseEntity.ok(new PortfolioDTO(portfolio));
    }

    @PostMapping
    public ResponseEntity<PortfolioDTO> criarPortfolio(@Valid @RequestBody PortfolioDTO portfolioRequestDTO) {
        try {
            System.out.println("Recebendo dados do request: " + portfolioRequestDTO);
            Portfolio novoPortfolio = portfolioService.salvar(portfolioRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new PortfolioDTO(novoPortfolio));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Portfolio> atualizarPortfolio(@PathVariable Long id, @RequestBody Portfolio portfolioAtualizado) {
        try{
            Portfolio portfolioAtualizadoSalvo = portfolioService.atualizar(id, portfolioAtualizado);
                    return ResponseEntity.ok(portfolioAtualizadoSalvo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPortfolio(@PathVariable Long id) {
        portfolioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}