package com.needuk.service;

import com.needuk.repository.RecomendacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class RecomendacaoService {

    private final RecomendacaoRepository recomendacaoRepository;

    public RecomendacaoService(RecomendacaoRepository recomendacaoRepository) {
        this.recomendacaoRepository = recomendacaoRepository;
    }
}