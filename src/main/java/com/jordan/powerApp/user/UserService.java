package com.jordan.powerApp.user;

import com.jordan.powerApp.registration.token.ConfirmationToken;
import com.jordan.powerApp.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ConfirmationTokenService confirmationTokenService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with username %s", username)));
	}

	public String registerUser(User user){
		boolean userEmailExists = userRepository.findUserByEmail(user.getEmail()).isPresent();
		boolean userNameExists = userRepository.findUserByUsername(user.getUsername()).isPresent();

		if (userEmailExists || userNameExists) {
			throw new IllegalStateException("Email or UserName already taken");
		}
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepository.save(user);
		//		TODO: Send Confirmation Token
		String token = UUID.randomUUID().toString();
		ConfirmationToken confirmationToken = new ConfirmationToken(
				token,
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15),
				user
		);
		confirmationTokenService.saveConfirmationToken(confirmationToken);
		return token;
//		TODO: Send Email
	}

	public int enableUser(String email) {
		return userRepository.enableAppUser(email);
	}

}
