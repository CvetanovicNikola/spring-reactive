package com.example.springReactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/student")

public class StudentController {
	
 
	private final StudentService studentService;
	
	
	public StudentController(StudentRepository studentRepository, StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping(value="new")
	public Mono<Student> createStudent(@RequestBody Student student){
		return studentService.createStudent(student);
	}

	@GetMapping(value = "all")
	  public Flux<Student> getAll() {
	    return studentService.getAllStudents();
	  }
	
	
	@GetMapping(value = "{id}")
	  public Mono<ResponseEntity<Student>> getStudent(@PathVariable long id) {
	    return studentService.getStudent(id)
	    		.switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found")))
	    		.map(ResponseEntity::ok);
	    		
	  }
	
	@GetMapping(value = "get_student_by_name/{name}")
	  public Mono<ResponseEntity<Student>> getStudentByName(@PathVariable String name) {
	    return studentService.getStudentByName(name)
	    		.switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found")))
	    		.map(ResponseEntity::ok);
	    		
	  }
	
	@DeleteMapping(value = "delete/{id}")
	public Mono<Void> deleteStudent(@PathVariable long id){
		return studentService.deleteStudent(id);
	}
	
	@PutMapping(value = "/update/{id}")
	public Mono<Student> updateStudent(@PathVariable long id, @RequestBody Student student){
		return studentService.updateStudent(id, student);
	}
}