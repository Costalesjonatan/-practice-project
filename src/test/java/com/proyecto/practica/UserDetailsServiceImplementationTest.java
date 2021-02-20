package com.proyecto.practica;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;

import com.proyecto.practica.model.Usuario;
import com.proyecto.practica.repository.UsuarioRepository;
import com.proyecto.practica.service.implementation.UserDetailsServiceImplementation;

class UserDetailsServiceImplementationTest {
	
	private UsuarioRepository usuarioRepository;
	private UserDetailsServiceImplementation userDetailsService;
	
	@Test
	public void loadUserByUsernameTest() {
		givenUsuarioRepository();
		giverUSerDetailsService();
		
		usuarioRepository.save(Usuario.builder().id(1).username("jonatan").password("costales").build());
		
		UserDetails userDetails = userDetailsService.loadUserByUsername("jonatan");
		
		assertThat(userDetails.getAuthorities().toString()).contains("ROLE_USER");
		
		System.out.println(userDetails.getAuthorities().toString());
	}
	
	private void givenUsuarioRepository() {
		usuarioRepository = new MockUsuarioRepository();
	}
	
	private void giverUSerDetailsService() {
		userDetailsService = new UserDetailsServiceImplementation(usuarioRepository);
	}
}
