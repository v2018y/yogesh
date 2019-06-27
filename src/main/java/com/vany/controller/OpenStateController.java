package com.vany.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
import com.vany.model.OpenSateBar;
import com.vany.repositeroy.BarRepo;
import com.vany.repositeroy.OpenStateRepo;

@RestController
@RequestMapping("/api")
public class OpenStateController {

	@Autowired
	OpenStateRepo openStateRepo;
	
	@Autowired
	BarRepo barRepo;

	// Get All OpenSate Records
	@GetMapping(value = "/bar/{itemId}/openState")
	public List<OpenSateBar> getAllOpenState() {
		return openStateRepo.findAll();
	}

	// Get OpenSate Record By Id
	@GetMapping(value = "/bar/{itemId}/openState/")
	public Optional<OpenSateBar> getOpenStateFindByItemId(@PathVariable Integer bid,Pageable pageable) {
		return openStateRepo.findById(bid);
	}

	// Save OpenSate Record
	@PostMapping(value = "/bar/{itemId}/openState/save")
	public OpenSateBar saveOpenState(@PathVariable Integer bid,@RequestBody OpenSateBar openBar) {
		Bar findBar= barRepo.findById(bid).orElseThrow(() -> new ResourceNotFoundException("Open State Item ", "id", bid));
		openBar.setBar(findBar);
		return openStateRepo.saveAndFlush(openBar);
    
	}

	// Update a OpenSate Record
	@PutMapping("/bar/{itemId}/openState/{openStateId}")
	public OpenSateBar updateOpenState(@PathVariable Integer bid,@PathVariable Integer opid, @RequestBody OpenSateBar openBar) {
		if(!barRepo.existsById(bid)) {
            throw new ResourceNotFoundException("Open State Item ", "id", bid);
        }
		OpenSateBar findOpenState = openStateRepo.findById(opid).orElseThrow(() -> new ResourceNotFoundException("Open State Not Found ", "id", opid));
		findOpenState.setSalesQty(openBar.getSalesQty());
		return openStateRepo.saveAndFlush(findOpenState);
	}

	// Delete a OpenSate Record
	@DeleteMapping("/bar/{itemId}/openState/{openStateId}")
	public ResponseEntity<?> deleteOpenState(@PathVariable Integer bid,@PathVariable Integer opid) {
		OpenSateBar findOpenState= openStateRepo.findById(bid).orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + bid + " and postId " + opid,null,bid));
		openStateRepo.delete(findOpenState);
		 return ResponseEntity.ok().build();
	}

}
