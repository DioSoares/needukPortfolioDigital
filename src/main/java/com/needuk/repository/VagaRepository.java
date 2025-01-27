package com.needuk.repository;

import com.needuk.model.Usuario;
import com.needuk.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
}
