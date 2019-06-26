package com.vany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vany.repositeroy.OpenStateRepo;

@RestController
@RequestMapping("/api")
public class OpenStateController {

	@Autowired
	OpenStateRepo openStateRepo;
}
