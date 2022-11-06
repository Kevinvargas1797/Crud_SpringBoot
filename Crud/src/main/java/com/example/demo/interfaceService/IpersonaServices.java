package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Persona;

public interface IpersonaServices {
	public List<Persona>Listar();
	public Optional<Persona>ListarId(int Id);
	public int save(Persona p);
	public void delete(int id);
	
}
