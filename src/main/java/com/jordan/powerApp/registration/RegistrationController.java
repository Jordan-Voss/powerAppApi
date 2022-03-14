package com.jordan.powerApp.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/register")
@AllArgsConstructor
public class RegistrationController {

	private RegistrationService registrationService;

	public String register(@RequestBody RegistrationRequest request) {
		return registrationService.register(request);
	}

}
