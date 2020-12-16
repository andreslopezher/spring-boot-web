package com.adatasoft.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping({"/","/index",""})
	public String index(Model model) {
		model.addAttribute("titulo", "Enviar parametros del Request HTTP GET.");
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(required = false, defaultValue = "sin texto") String texto, Model model) {
		model.addAttribute("titulo", "Recibir parametros del request HTTP GET");
		model.addAttribute("resultado", "El texto enviado es: " + texto);
		return "params/ver";
	}

	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("titulo", "Enviar parametros de distintos tipos por el Request GET");
		model.addAttribute("resultado", ".. El saludo enviado es '" + saludo + "' y el número es '" + numero + "'");
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		Integer numero = 0;
		try {
			numero = Integer.parseInt(request.getParameter("numero")); 	
		} catch(NumberFormatException e){
			numero = 0;
		}
		String saludo  = request.getParameter("saludo");
		model.addAttribute("titulo", "Enviar parametros de distintos tipos usando HttpServletRequest");
		model.addAttribute("resultado", ".. El saludo enviado es '" + saludo + "' y el número es '" + numero + "'");
		return "params/ver";
	}

}
