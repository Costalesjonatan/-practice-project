package com.proyecto.practica;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.practica.repository.UsuarioRepository;
import com.proyecto.practica.service.UsuarioService;

class UserServiceImplementationTest {
	
	@Mock
	private UsuarioRepository usuarioRepository;
	@Autowired
	private UsuarioService usuarioService;
	
	@Test
	public void UsuarioServiceAutoWiredTest() {
		assertThat(usuarioService != null);
	}
	
	@Test
	public void UsuarioRepositoryMockTest() {
		assertThat(usuarioRepository != null);
	}
}
