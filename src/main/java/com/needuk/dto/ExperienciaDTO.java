package com.needuk.dto;

import com.needuk.model.Experiencia;

import java.time.LocalDate;

public class ExperienciaDTO {
    private Long id;
    private String tipo;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public ExperienciaDTO(Experiencia experiencia) {
        this.id = experiencia.getId();
        this.tipo = experiencia.getTipo();
        this.descricao = experiencia.getDescricao();
        this.dataInicio = experiencia.getDataInicio();
        this.dataFim = experiencia.getDataFim();
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }
}