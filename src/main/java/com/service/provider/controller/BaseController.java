package com.service.provider.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("server")
public class BaseController {
	
	private final static Logger LOGGER=LoggerFactory.getLogger(BaseController.class);
    
	@RequestMapping(value = "query", method = RequestMethod.GET)
	public String query(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "id", required = false) String id) {
		LOGGER.info("BaseController.query:{}",id);
		return "hello world";
	}
}
