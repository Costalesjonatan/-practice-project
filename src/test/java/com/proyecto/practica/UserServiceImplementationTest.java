package com.proyecto.practica;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.proyecto.practica.model.Usuario;
import com.proyecto.practica.repository.UsuarioRepository;
import com.proyecto.practica.service.implementation.UsuarioServiceImplementation;

class UserServiceImplementationTest {
	
	@Mock
	private UsuarioRepository usuarioRepository;
	@Mock
	private BCryptPasswordEncoder passwordEncoder;
	private UsuarioServiceImplementation usuarioService;
	
	private Usuario usuario;
	
	@BeforeEach
	public void setUp(){
		
		usuarioRepository = mock(UsuarioRepository.class);
		usuario = Usuario.builder().id(1).username("jonatan").password("costales").build();
		Optional<Usuario> optionalUsuario = Optional.of(usuario);
		when(usuarioRepository.save(usuario)).thenReturn(usuario);
		when(usuarioRepository.findById((long) 1)).thenReturn(optionalUsuario);
		when(usuarioRepository.findByusername("jonatan")).thenReturn(usuario);
		
		
		passwordEncoder = mock(BCryptPasswordEncoder.class);
		when(passwordEncoder.encode("costales")).thenReturn("1234");
		
		
		usuarioService = new UsuarioServiceImplementation(usuarioRepository, passwordEncoder);
	}
	
	@Test
	public void shouldCreateUsuario(){
		usuarioService.registrar(usuario);
		Usuario usuario = usuarioRepository.findById((long) 1).get();
		
		assertTrue(usuario.getId() == 1);
		assertThat(usuario).isNotNull();
		assertTrue(usuario.getPassword().equals("1234"));
	}
	
	@Test
	public void shouldFindUsuarioByUsername(){
		usuarioService.registrar(usuario);
		Usuario usuario = usuarioService.findbyUsername("jonatan");
		
		assertTrue(usuario.getId() == 1);
		assertThat(usuario).isNotNull();
		assertTrue(usuario.getPassword().equals("1234"));
	}
}
