package com.proyecto.practica.service;

import com.proyecto.practica.model.Usuario;

public interface UserService {
	public Usuario findbyUsername(String username);
	public Usuario registrar(Usuario usuario);
}
