package com.adatasoft.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

import com.adatasoft.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.index.controller.titulo.index}")
	private String tituloIndex;
	
	@Value("${texto.index.controller.titulo.perfil}")
	private String tituloPerfil;
	
	@Value("${texto.index.controller.titulo.listar}")
	private String tituloListar;

	@GetMapping({ "/index", "/", "", "/home" })
	/*
	 * Otra forma de enviar datos a la vista public ModelAndView index(ModelAndView
	 * mv) { mv.addObject("titulo", "Hola Spring Framework con ModelAndView!");
	 * mv.setViewName("index"); return mv; }
	 */
	public String index(Model model) {
		model.addAttribute("titulo", tituloIndex);
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Juan Andrés");
		usuario.setApellido("López Hernández");
		usuario.setEmail("andreslopezher@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", tituloPerfil.concat(usuario.getNombre()));
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo",tituloListar);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Pedro", "Mendoza", "pedromendoza@correo.com"),
				new Usuario("Ruperto", "Jimenez", "rupertojim@outlook.com"),
				new Usuario("Samanta", "Torres", "samato@correo.com"),
				new Usuario("Angelina", "Jolie", "angelinajolie@correo.com"),
				new Usuario("Vanessa", "Toloza", "vanessatoloza@correo.com"),
				new Usuario("Javier", "Molina", "javimolina@gmail.com"),
				new Usuario("Venustiano", "Carranza", "revocarranzav@gmail.com"),
				new Usuario("Betzayda", "Martinez", "bmartinez23@correo.com"),
				new Usuario("Gilberto", "Torres Ordoñez", "gilbertorres@gmail.com"),
				new Usuario("Adriana", "Hernández de López", "adrimhg@gmail.com"));
		return usuarios;
	}

}
