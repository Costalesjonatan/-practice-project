package com.proyecto.practica.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.practica.model.Usuario;
import com.proyecto.practica.service.UsuarioService;

@Controller
public class SingUpController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/singup")
	public String registro(Model model) {
		model.addAttribute("usuario", new Usuario());
		
		return "singup";
	}
	
	@PostMapping("/singup")
	public String registro(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "redirect:/singup";
		}
		else {
			model.addAttribute("usuario", usuarioService.registrar(usuario));
		}
		
		return "redirect:/login";
	}
}
