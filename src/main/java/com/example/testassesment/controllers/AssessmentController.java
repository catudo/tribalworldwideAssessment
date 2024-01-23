package com.example.testassesment.controllers;

import com.example.testassesment.service.AssessmentService.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("assessment")
public class AssessmentController {

    public AssessmentService service;

    @Autowired
    public AssessmentController(AssessmentService service){
        this.service = service;

    }

    @GetMapping("random")
    public ResponseEntity<Set> listRandomEntities() throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(service.retrieveRandomObject(), HttpStatus.OK);
    }




}
