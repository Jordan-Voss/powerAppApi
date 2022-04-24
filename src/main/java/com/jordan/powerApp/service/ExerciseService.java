package com.jordan.powerApp.service;

import com.jordan.powerApp.models.Exercise;
import com.jordan.powerApp.models.User;
import com.jordan.powerApp.models.UserDetailsImpl;
import com.jordan.powerApp.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Transactional
    public List<Exercise> getExercisesByUser(User user) throws UsernameNotFoundException {
        List<Exercise> exercise = exerciseRepository.findExerciseByUser(user);
        return exercise;
    }
}
