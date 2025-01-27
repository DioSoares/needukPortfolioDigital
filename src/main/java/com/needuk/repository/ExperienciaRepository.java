package com.needuk.repository;

import com.needuk.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienciaRepository extends JpaRepository<Usuario, Long> {
}
