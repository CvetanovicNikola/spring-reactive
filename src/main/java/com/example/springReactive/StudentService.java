package com.example.springReactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {
	@Autowired
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	public Mono<Student> createStudent(Student student){
		return studentRepository.save(student);
	}
	public Flux<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	@Transactional
	public Mono<Student> updateStudent(long id, Student student){
		return studentRepository.findById(id)
				.flatMap(s -> {
					s.setName(student.getName());
					s.setLastName(student.getLastName());
					s.setDepartment(student.getDepartment());
					return studentRepository.save(s);
				})
				.switchIfEmpty(studentRepository.save(student.setAsNew()));
	}
	@Transactional
	public Mono<Void> deleteStudent(long id){
		return studentRepository.findById(id)
				.flatMap(studentRepository::delete);

	}
	public Mono<Student> getStudent(long id){
		return studentRepository.findById(id);
	}
	public Mono<Student> getStudentByName(String name){
		return studentRepository.getStudentByName(name);
	}
}
