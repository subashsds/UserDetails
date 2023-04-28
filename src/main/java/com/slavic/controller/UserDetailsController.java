package com.slavic.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.slavic.exception.BadRequest;

@RestController
@RequestMapping("/user")
public class UserDetailsController {
	@Autowired
	RestTemplate restTemplate;
	
	private  final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@GetMapping(value = "/getplans_details")
	public String method4() {
		LOG.info("Inside method4");
		return "Hello World JavaInUse";
}
	@PostMapping("/user-details")
	public @ResponseBody String getUserDetails(@RequestBody HashMap<String, String> username) {
		String user = "success";
		if("employee1".equals(username.get("username"))|| "participant1".equals(username.get("username")) || "sponsor1".equals(username.get("username"))) {
			LOG.info("get user"+username+" Details Successfully");
			user = username.get("username");
		}else {
			LOG.info("No such user with username" +username);
			throw new BadRequest("No such user with username" +username);
		}
		return "success";
	}
	
	
	
	
}
