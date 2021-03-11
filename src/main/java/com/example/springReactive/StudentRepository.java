package com.example.springReactive;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;

import reactor.core.publisher.Mono;

public interface StudentRepository extends R2dbcRepository<Student, Long>{
	
	@Query(value="select * from student s where s.name = :name limit 1")
	Mono<Student> getStudentByName(@Param("name") String name);

	Mono<Student> save(Mono<Student> student);
}
