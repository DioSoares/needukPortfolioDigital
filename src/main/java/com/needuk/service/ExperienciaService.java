package com.needuk.service;

import com.needuk.repository.ExperienciaRepository;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService {

    private final ExperienciaRepository experienciaRepository;

    public ExperienciaService(ExperienciaRepository experienciaRepository) {
        this.experienciaRepository = experienciaRepository;
    }

}