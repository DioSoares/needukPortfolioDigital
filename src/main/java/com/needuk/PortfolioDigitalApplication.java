package com.needuk;

import com.needuk.model.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioDigitalApplication {

	public static void main(String[] args) {

		 SpringApplication.run(PortfolioDigitalApplication.class, args);

		/*Usuario usuario = new Usuario();
		usuario.setNome("João");
		System.out.println(usuario.getNome()); */
	}

}