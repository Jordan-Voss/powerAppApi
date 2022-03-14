package com.jordan.powerApp.registration;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

	private final String firstName;

	private final String lastName;

	private final String username;

	private final String email;

	private final String password;

}
