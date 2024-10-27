package com.biblioteca.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.demo.model.Carta;

public interface CartaRepository extends JpaRepository<Carta, Long> {
    
}
