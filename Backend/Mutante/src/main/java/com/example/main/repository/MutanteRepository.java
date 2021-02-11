package com.example.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.main.entities.Mutante;

public interface MutanteRepository extends JpaRepository<Mutante, Integer> {

	@Query("SELECT COUNT(*) FROM Mutante WHERE mutacion = 'normal'")
	Long contarHumanos();
	
	@Query("SELECT COUNT(*) FROM Mutante WHERE mutacion = 'mutante'")
	Long contarMutantes();
	
}
