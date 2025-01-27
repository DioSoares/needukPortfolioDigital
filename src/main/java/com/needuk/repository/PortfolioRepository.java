package com.needuk.repository;

import com.needuk.model.Portfolio;
import com.needuk.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
