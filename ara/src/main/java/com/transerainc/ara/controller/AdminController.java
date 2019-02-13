/**
 * 
 */
package com.transerainc.ara.controller;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Admin controller
 * 
 * @author Prashanth
 * 
 */
@Controller
public class AdminController {
	private Logger lgr = LoggerFactory.getLogger(AdminController.class);

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	public AdminController() {
	}

	@RequestMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		lgr.debug("Accessing the welcome page");
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
}
