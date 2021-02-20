package com.proyecto.practica.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.practica.model.Usuario;
import com.proyecto.practica.repository.UsuarioRepository;
import com.proyecto.practica.service.UsuarioService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioServiceImplementation implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Usuario findbyUsername(String username) {
		return usuarioRepository.findByUserName(username);
	}

	@Override
	public Usuario registrar(Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return usuarioRepository.save(usuario);
	}

}
