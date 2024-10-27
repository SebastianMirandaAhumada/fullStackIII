package com.biblioteca.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.demo.model.Libro;


public interface LibroRepository extends JpaRepository<Libro, Long> {

    
} 
