package com.example.springReactive;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;



public class Student {
@Id
private Long id;
private String name;
@Override
public String toString() {
	return "Member [id=" + id + ", name=" + name + "]";
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Student(Long id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public Student() {
	super();

}

}
