package com.proyecto.practica;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.practica.model.Usuario;
import com.proyecto.practica.repository.UsuarioRepository;
import com.proyecto.practica.service.UsuarioService;

class UserServiceImplementationTest {
	
	private UsuarioRepository mockUsuarioRepository;
	private UsuarioService usuarioService;
	
	@Test
	public void shouldCreateUsuario() {
		givenUserRepository();
		givenUsuarioService();
		usuarioService.registrar(Usuario.builder().id(1).username("jonatan").password("costales").build());
		assertThat(usuarioService.findbyUsername("jonatan") != null);
	}
	
	private void givenUserRepository() {
		mockUsuarioRepository = new MockUsuarioRepository();
	}

	private void givenUsuarioService() {
		usuarioService = new UsuarioService(mockUsuarioRepository);
	}
	
}
