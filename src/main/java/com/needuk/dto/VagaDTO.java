package com.needuk.dto;

import com.needuk.model.Vaga;

import java.time.LocalDateTime;

public class VagaDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private String requisitos;
    private LocalDateTime dataPublicacao;

    public VagaDTO(Vaga vaga) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.requisitos = requisitos;
        this.dataPublicacao = dataPublicacao;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }
}