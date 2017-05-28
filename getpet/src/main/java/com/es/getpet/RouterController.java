package com.es.getpet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouterController {

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
}
