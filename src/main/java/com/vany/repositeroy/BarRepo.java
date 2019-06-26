package com.vany.repositeroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vany.model.Bar;


public interface BarRepo extends JpaRepository<Bar, Integer> {

	
}
