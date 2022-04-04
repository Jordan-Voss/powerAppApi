package com.jordan.powerApp.repository;

import com.jordan.powerApp.models.ERole;
import com.jordan.powerApp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(ERole name);

}
