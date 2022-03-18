package com.jordan.powerApp.repository;

import com.jordan.powerApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {

	 Optional<User> findUserByEmail(String email);

	 Optional<User> findUserByUsername(String username);

	@Transactional
	@Modifying
	@Query("UPDATE User user " +
			"SET user.enabled = TRUE WHERE user.email = ?1")
	int enableAppUser(String email);

}
