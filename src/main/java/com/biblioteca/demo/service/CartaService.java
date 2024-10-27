package com.biblioteca.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.demo.model.Carta;
import com.biblioteca.demo.repository.CartaRepository;

@Service
public class CartaService {
    @Autowired
    private CartaRepository cartaRepository;

    public List<Carta> listaCartas(){
        return cartaRepository.findAll();
    }

    public Optional<Carta> obtenerCarta(Long id){
        return cartaRepository.findById(id);
    }
    public Carta guardarCarta(Carta carta){
        return cartaRepository.save(carta);
    }
    public void eliminarCarta(Long carta){
        cartaRepository.deleteById(carta);
    }
}
