package com.jordan.powerApp.repository;

import com.jordan.powerApp.models.Exercise;
import com.jordan.powerApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findExerciseByUser(User user);
}
