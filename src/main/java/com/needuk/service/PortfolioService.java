package com.needuk.service;

import com.needuk.dto.PortfolioDTO;
import com.needuk.model.Portfolio;
import com.needuk.model.Usuario;
import com.needuk.repository.PortfolioRepository;
import com.needuk.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    private final PortfolioRepository portfolioRepository;

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository, UsuarioRepository usuarioRepository) {
        this.portfolioRepository = portfolioRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Portfolio> listarTodos() {
        return portfolioRepository.findAll();
    }

    public Optional<Portfolio> buscarPorId(Long id) {
        return portfolioRepository.findById(id);
    }

    public Portfolio salvar(PortfolioDTO portfolioRequestDTO) {

        Usuario usuario = usuarioRepository.findById(portfolioRequestDTO.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        Portfolio portfolio = new Portfolio();
        portfolio.setUsuario(usuario);
        portfolio.setTitulo(portfolioRequestDTO.getTitulo());
        portfolio.setDescricao(portfolioRequestDTO.getDescricao());

        return portfolioRepository.save(portfolio);
    }

    public Portfolio atualizar(Long id, Portfolio portfolioAtualizado) {
        Optional<Portfolio> portifolioExistente = portfolioRepository.findById(id);
        if (portifolioExistente.isPresent()) {
            Portfolio portfolio = portifolioExistente.get();
            portfolio.setTitulo(portfolioAtualizado.getTitulo());
            portfolio.setDescricao(portfolioAtualizado.getDescricao());
            return portfolioRepository.save(portfolio);
        } else {
            throw new RuntimeException("Portfólio não encontrado");
        }
    }

    public void deletar(Long id) {
        portfolioRepository.deleteById(id);
    }
}