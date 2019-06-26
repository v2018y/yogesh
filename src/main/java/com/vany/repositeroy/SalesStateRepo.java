package com.vany.repositeroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vany.model.SalesStateBar;

public interface SalesStateRepo extends JpaRepository<SalesStateBar, Integer> {

}
