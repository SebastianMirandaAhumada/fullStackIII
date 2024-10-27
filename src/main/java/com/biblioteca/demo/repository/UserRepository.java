package com.biblioteca.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.biblioteca.demo.model.Usuarios;

public interface UserRepository extends JpaRepository<Usuarios, Long> {

}
