package com.example.springReactive;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;


@XmlRootElement

public class Student implements Persistable<Long>{
@Id
private Long id;
private String name;
private String lastName;
private String department;

@Transient
private boolean isNew;



public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
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
public Student(String name) {
	super();
	this.name = name;
}
public Student() {
	super();

}

public Student(String name, String lastName, String department, boolean isNew) {
	super();
	this.name = name;
	this.lastName = lastName;
	this.department = department;
	this.isNew = isNew;
}
public Student(Long id, String name, String lastName, String department, boolean isNew) {
	super();
	this.id = id;
	this.name = name;
	this.lastName = lastName;
	this.department = department;
	this.isNew = isNew;
}
@Override
@Transient
public boolean isNew() {
	return this.isNew || id==null;
}
public Student setAsNew() {
	this.isNew = true;
	return this;
}

}
