package com.jordan.powerApp.controller;

import com.jordan.powerApp.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/sheet")
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @GetMapping("/get-exercise")
    public String allAccess() {
        return "Public Content.";
    }
}
