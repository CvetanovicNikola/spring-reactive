package com.example.springReactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/member")

public class StudentController {
	
 private final StudentRepository studentRepository;

  
 @Autowired
 public StudentController(StudentRepository studentRepository) {
	super();
	this.studentRepository = studentRepository;
}


@GetMapping()
  public Flux<Student> getAll() {
    return studentRepository.findAll();
  }


@GetMapping(value = "/{name}")
  public Mono<Student> getOne(@PathVariable String name) {
    return studentRepository.findByName(name);
  }
}