package com.proyecto.practica;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.proyecto.practica.model.Usuario;
import com.proyecto.practica.repository.UsuarioRepository;
import com.proyecto.practica.service.UsuarioService;
import com.proyecto.practica.service.implementation.UsuarioServiceImplementation;

class UserServiceImplementationTest {
	
	private UsuarioRepository mockUsuarioRepository;
	private UsuarioService usuarioService;
	private BCryptPasswordEncoder passwordEncoder;
	
	@Test
	public void shouldCreateUsuario() {
		givenUserRepository();
		givenPasswordEnconder();
		givenUsuarioService();
		
		usuarioService.registrar(Usuario.builder().id(1).username("jonatan").password("costales").build());
		Usuario usuario = mockUsuarioRepository.findById((long) 1).get();
		
		assertThat(usuario.getId() == 1);
		assertThat(usuario != null);
		assertThat(passwordEncoder.matches("costales", usuario.getPassword()));
	}
	
	@Test
	public void shouldFindUsuarioByUsername(){
		givenUserRepository();
		givenPasswordEnconder();
		givenUsuarioService();
		
		usuarioService.registrar(Usuario.builder().id(1).username("jonatan").password("costales").build());
		Usuario usuario = usuarioService.findbyUsername("jonatan");
		
		assertThat(usuario.getId() == 1);
		assertThat(usuario != null);
		assertThat(passwordEncoder.matches("costales", usuario.getPassword()));
	}
	
	private void givenUserRepository() {
		mockUsuarioRepository = new MockUsuarioRepository();
	}

	private void givenUsuarioService() {
		usuarioService = new UsuarioServiceImplementation(mockUsuarioRepository, passwordEncoder);
	}
	
	private void givenPasswordEnconder() {
		passwordEncoder = new BCryptPasswordEncoder();
	}
}
