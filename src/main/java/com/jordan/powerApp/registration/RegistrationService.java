package com.jordan.powerApp.registration;

import com.jordan.powerApp.user.Role;
import com.jordan.powerApp.user.User;
import com.jordan.powerApp.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

	private final EmailValidator emailValidator;
	private final UserService userService;
	public String register(RegistrationRequest request) {
		boolean isValidEmail = emailValidator.test(request.getEmail());

		if (!isValidEmail) {
			throw new IllegalStateException("Invalid Email");
		}
		return userService.registerUser(new User(
				request.getFirstName(),
				request.getLastName(),
				request.getUsername(),
				request.getEmail(),
				request.getPassword(),
				Role.USER
		));
	}

}
