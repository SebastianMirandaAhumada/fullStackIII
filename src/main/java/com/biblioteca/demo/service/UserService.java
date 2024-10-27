package com.biblioteca.demo.service;

import java.util.List;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.biblioteca.demo.model.Libro;
import com.biblioteca.demo.model.Usuarios;
import com.biblioteca.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Usuarios createUser(Usuarios user) {       
        return userRepository.save(user);
    }

    public List<Usuarios> listaUsuarios() {
        return userRepository.findAll();
    }

    public Optional<Usuarios> findByUsername(Long id) {
        return userRepository.findById(id);
    }
}
