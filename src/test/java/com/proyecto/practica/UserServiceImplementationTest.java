package com.proyecto.practica;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.proyecto.practica.model.Usuario;
import com.proyecto.practica.repository.UsuarioRepository;
import com.proyecto.practica.service.UsuarioService;
import com.proyecto.practica.service.implementation.UsuarioServiceImplementation;

class UserServiceImplementationTest {
	
	private UsuarioRepository mockUsuarioRepository;
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@Test
	public void shouldCreateUsuario() {
		System.out.println(usuarioService != null);
		givenUserRepository();
		//when(mockUsuarioRepository.findById(any(long.class))
		givenPasswordEnconder();
		//givenUsuarioService();
		
		usuarioService.registrar(Usuario.builder().id(1).username("jonatan").password("costales").build());
		Usuario usuario = mockUsuarioRepository.findById((long) 1).get();
		
		assertTrue(usuario.getId() == 1);
		assertThat(usuario).isNotNull();
		System.out.println(usuario.toString());
		assertTrue(passwordEncoder.matches("costales", usuario.getPassword()));
	}
	
	@Test
	public void shouldNotCreateUsuario() {
		
	}
	
	@Test
	public void shouldFindUsuarioByUsername(){
		givenUserRepository();
		givenPasswordEnconder();
		givenUsuarioService();
		
		usuarioService.registrar(Usuario.builder().id(1).username("jonatan").password("costales").build());
		Usuario usuario = usuarioService.findbyUsername("jonatan");
		
		assertTrue(usuario.getId() == 1);
		assertThat(usuario).isNotNull();
		assertTrue(passwordEncoder.matches("costales", usuario.getPassword()));
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
