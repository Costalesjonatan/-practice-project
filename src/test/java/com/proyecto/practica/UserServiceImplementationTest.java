package com.proyecto.practica;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.practica.model.Usuario;
import com.proyecto.practica.repository.UsuarioRepository;
import com.proyecto.practica.service.UsuarioService;

class UserServiceImplementationTest {
	
	private UsuarioRepository usuarioRepository;
	private UsuarioService usuarioService;
	
	@Test
	public void shouldCreateUsuario() {
		usuarioService.registrar(Usuario.builder().id(1).username("jonatan").password("costales").build());
		assertThat(usuarioService.findbyUsername("jonatan") != null);
	}
	
	private void givenUserRepository() {
		usuarioRepository = new MockUserRepository();
	}
}
