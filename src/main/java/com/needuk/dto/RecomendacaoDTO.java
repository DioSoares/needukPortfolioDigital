package com.needuk.dto;

import com.needuk.model.Recomendacao;

import java.time.LocalDateTime;

public class RecomendacaoDTO {
    private Long id;
    private Long usuarioId;
    private Long vagaId;
    private LocalDateTime dataRecomendacao;

    public RecomendacaoDTO(Recomendacao recomendacao) {
        this.id = recomendacao.getId();
        this.usuarioId = recomendacao.getUsuario().getId();
        this.vagaId = recomendacao.getVaga().getId();
        this.dataRecomendacao = recomendacao.getDataRecomendacao();
    }

    public Long getId() {
        return id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public Long getVagaId() {
        return vagaId;
    }

    public LocalDateTime getDataRecomendacao() {
        return dataRecomendacao;
    }
}