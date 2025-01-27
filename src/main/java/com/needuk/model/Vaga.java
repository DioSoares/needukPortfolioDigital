package com.needuk.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "vagas")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório.")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória.")
    private String descricao;

    @NotBlank(message = "Os requisitos são obrigatórios.")
    private String requisitos;

    @Column(name = "data_publicacao", updatable = false)
    private LocalDateTime dataPublicacao;

    @OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recomendacao> recomendacoes = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.dataPublicacao = LocalDateTime.now();
    }
}