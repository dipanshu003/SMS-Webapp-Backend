package com.sms.apis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentRelatives {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String relation;
	private String name;
	private int age;

	public StudentRelatives() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentRelatives(int id, String relation, String name, int age) {
		super();
		this.id = id;
		this.relation = relation;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentRelatives [id=" + id + ", relation=" + relation + ", name=" + name + ", age=" + age + "]";
	}

}
