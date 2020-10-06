package com.apirestfull.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirestfull.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


}