package com.vany.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vany.model.Empolyee;
import com.vany.repositeroy.EmpolyeRepo;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmpolyeRepo empolyeRepo;
	
	@GetMapping(value="/")
	public java.util.List<Empolyee> findAll()
	{
		return  empolyeRepo.findAll();
	}
	
	@GetMapping(value="/{id}")
	public  Optional<Empolyee> findById(@PathVariable Integer id)
	{
		return  empolyeRepo.findById(id);
	}
	
	@PostMapping(value = "/save")
	public Empolyee saveData(@RequestBody Empolyee emp){
		return empolyeRepo.saveAndFlush(emp);
	}
	
}
