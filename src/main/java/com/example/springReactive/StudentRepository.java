package com.example.springReactive;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface StudentRepository extends R2dbcRepository<Student, Long>{
	Mono<Student> findByName(String name);
}
