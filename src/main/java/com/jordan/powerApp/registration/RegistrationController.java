package com.jordan.powerApp.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/register")
@AllArgsConstructor
public class RegistrationController {

	private RegistrationService registrationService;

	@PostMapping()
	public String register(@RequestBody RegistrationRequest request) {
		return registrationService.register(request);
	}


	@GetMapping(path = "confirm")
	public String confirm(@RequestParam("token") String token) {
		return registrationService.confirmToken(token);
	}
}
