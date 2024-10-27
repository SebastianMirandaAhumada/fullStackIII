package com.biblioteca.demo.controller;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.biblioteca.demo.exception.ResourceNotFoundException;
import com.biblioteca.demo.model.Libro;
import com.biblioteca.demo.model.Usuarios;
import com.biblioteca.demo.service.UserService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/users")
public class UserController {
        @Autowired
    private UserService userService;


    @GetMapping()
    public List<Usuarios> listaUsuarios(){
        return userService.listaUsuarios();
    }

    @PostMapping()
    public ResponseEntity<Usuarios> registerUser(@Valid @RequestBody Usuarios user) {
        Usuarios nuevoUser = userService.createUser(user);
        return new ResponseEntity<>(nuevoUser, HttpStatus.CREATED);

    }
 @PutMapping("/{id}")
    public ResponseEntity<Usuarios> actualizarLibro(@PathVariable Long id, @Valid @RequestBody Usuarios detallesUsuarios) {
        Usuarios usuarios = userService.findByUsername(id)
                .orElseThrow(() -> new ResourceNotFoundException("El libro con ID " + id + " no fue encontrado."));

        usuarios.setUser(usuarios.getUser());
        usuarios.setRoles(usuarios.getRoles());
        
        Usuarios usuarioActualizado = userService.createUser(usuarios);
        return ResponseEntity.ok(usuarioActualizado);
    }

   
}
