package com.vany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vany.exception.ResourceNotFoundException;
import com.vany.model.Bar;
import com.vany.repositeroy.BarRepo;

@RestController
@RequestMapping("/api")
public class BarController {

	@Autowired
	BarRepo barRepo;
	
	//Get All Item
		@GetMapping(value="/bar")
		public List<Bar> getAllItem()
		{
			return  barRepo.findAll();
		}
		
		//Get Item By Id
		@GetMapping(value="/bar/{id}")
		public  Bar itemFindById(@PathVariable Integer id)
		{
			return  barRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		}
		
		//Save Item
		@PostMapping(value = "/bar/save")
		public Bar saveItem(@RequestBody Bar bar){
			return barRepo.saveAndFlush(bar);
		}
		
		// Update a Employee
		@PutMapping("/bar/{id}")
		public Bar updateEmpolyee(@PathVariable Integer id,@RequestBody Bar bar) {
			
			Bar findBar=barRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bar ", "id", id));
			
			findBar.setItemName(bar.getItemName());
			findBar.setItemPrice(bar.getItemPrice());
			findBar.setItemQty(bar.getItemQty());
			return  barRepo.saveAndFlush(findBar);
		}
		
		// Delete a Employee
		@DeleteMapping("/bar/{id}")
		public ResponseEntity<?> deleteEmployee(@PathVariable Integer id){
			Bar findBar=barRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bar", "id", id));
			barRepo.delete(findBar);
			return ResponseEntity.ok().build();
		}
}
