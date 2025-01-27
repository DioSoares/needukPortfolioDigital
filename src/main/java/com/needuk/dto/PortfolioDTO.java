package com.needuk.dto;

import com.needuk.model.Portfolio;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class PortfolioDTO {
    private Long id;
    private String descricao;
    private String titulo;
    private LocalDateTime dataCriacao;
    private UsuarioDTO usuario;

    public PortfolioDTO(Portfolio portfolio) {
        this.id = portfolio.getId();
        this.descricao = portfolio.getDescricao();
        this.titulo = portfolio.getTitulo();
        this.dataCriacao = portfolio.getDataCriacao();
        this.usuario = new UsuarioDTO(portfolio.getUsuario());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
}