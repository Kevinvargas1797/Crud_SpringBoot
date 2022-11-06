package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Persona;

@Repository
public interface Ipersona extends CrudRepository<Persona, Integer>{

}
