package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.IpersonaServices;
import com.example.demo.modelo.Persona;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IpersonaServices service;
	
	@GetMapping("/Listar")
	public String Listar(Model model) {
		List<Persona>personas=service.Listar();
		model.addAttribute("personas", personas);
		return "index";
	}
	
	@GetMapping("/new")
	public String Agregar(Model model) {
		model.addAttribute("persona", new Persona());
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@Valid Persona p, Model model){
		service.save(p);
		return "redirect:/Listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Persona>persona=service.ListarId(id);
		model.addAttribute("persona", persona);
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/Listar";
	}
}
