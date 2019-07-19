package com.vany.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.vany.model.DAOUser;
import com.vany.model.OpenSateBar;
import com.vany.repositeroy.BarRepo;
import com.vany.repositeroy.OpenStateRepo;
import com.vany.repositeroy.UserDao;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class OpenStateController {

	@Autowired
	OpenStateRepo openStateRepo;

	@Autowired
	BarRepo barRepo;

	@Autowired
	UserDao userDao;

	// This Functiosn get Username form Token And Return the User Details
	public DAOUser getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		System.out.println("Your User Name :" + username);

		DAOUser daoUser = userDao.findByUsername(username);
		return daoUser;
	}

	public List<OpenSateBar> getListBarByUser() {
		List<Bar> barList = barRepo.findByDaoUser(getUser());

		// here we decaler the temp result of openstate object for later we return this
		// object
		List<OpenSateBar> result = new ArrayList<OpenSateBar>();

		// in this for loop we whatever get bar item data we return form that we fetch
		// the specfic openstate data and add to temp vairlbe
		for (Bar barItem : barList) {
			result.addAll(barItem.getOpenState());
		}

		// here we print the result
		System.out.println("Your Data" + result);

		// here we return the result.
		return result;
	}

	// Get All OpenSate Records
	@GetMapping(value = "/bar/openState")
	public List<OpenSateBar> getAllOpenState() {
		return getListBarByUser();
	}

	// Get All OpenSate Records by Date
	@GetMapping(value = "/bar/openState/date/{Date}")
	public List<OpenSateBar> getAllOpenStateByDate(@PathVariable(value = "Date") String userDate) {
		// This Line Get All Open state Bar data According to user.
		List<OpenSateBar> fetchOpenStateBar = getListBarByUser();
		
		//	This Line Declare The empty result of OpenState Bar Which will return By Later
		List<OpenSateBar> result = new ArrayList<OpenSateBar>();
		
		//	Here We Checked the and Filter Data According to date
		for (OpenSateBar barItem : fetchOpenStateBar) {
			if (barItem.getCreatedAt().equals(userDate)) {
				result.add(barItem);
			}
		}
		
		//	Here We what We Get result will be return
		return result;
	}

	// Get OpenSate Record By Id
	@GetMapping(value = "/bar/openState/id/{openStateId}")
	public Optional<OpenSateBar> getOpenStateFindByItemId(@PathVariable(value = "openStateId") Integer opid,
			Pageable pageable) {
		return openStateRepo.findById(opid);
	}

	// Save OpenSate Record
	@PostMapping(value = "/bar/{itemId}/openState/save")
	public OpenSateBar saveOpenState(@PathVariable(value = "itemId") Integer bid, @RequestBody OpenSateBar openBar) {
		Bar findBar = barRepo.findById(bid)
				.orElseThrow(() -> new ResourceNotFoundException("Open State Item ", "id", bid));
		openBar.setBar(findBar);
		return openStateRepo.saveAndFlush(openBar);

	}

	// Save All OpenSate Record
	@PostMapping(value = "/bar/{itemId}/openState/saveAll")
	public List<OpenSateBar> saveOpenStateBatch(@PathVariable(value = "itemId") Integer bid,
			@RequestBody List<OpenSateBar> openBar) {
		Bar findBar = barRepo.findById(bid)
				.orElseThrow(() -> new ResourceNotFoundException("Open State Item ", "id", bid));
		for (OpenSateBar data : openBar) {
			data.setBar(findBar);
		}
		return openStateRepo.saveAll(openBar);
	}

	// Update a OpenSate Record
	@PutMapping("/bar/{itemId}/openState/{openStateId}")
	public OpenSateBar updateOpenState(@PathVariable(value = "itemId") Integer bid,
			@PathVariable(value = "openStateId") Integer opid, @RequestBody OpenSateBar openBar) {
		if (!barRepo.existsById(bid)) {
			throw new ResourceNotFoundException("Open State Item ", "id", bid);
		}
		OpenSateBar findOpenState = openStateRepo.findById(opid)
				.orElseThrow(() -> new ResourceNotFoundException("Open State Not Found ", "id", opid));
		findOpenState.setOpenQty(openBar.getOpenQty());
		return openStateRepo.saveAndFlush(findOpenState);
	}

	// Delete a OpenSate Record
	@DeleteMapping("/bar/{itemId}/openState/{openStateId}")
	public ResponseEntity<?> deleteOpenState(@PathVariable(value = "itemId") Integer bid,
			@PathVariable(value = "openStateId") Integer opid) {
		OpenSateBar findOpenState = openStateRepo.findById(opid).orElseThrow(() -> new ResourceNotFoundException(
				"Open State not found with id " + bid + " and postId " + opid, null, bid));
//		openStateRepo.delete(findOpenState);
		openStateRepo.delete(findOpenState);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}

}
