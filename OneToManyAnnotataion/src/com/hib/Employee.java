package com.hib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="emp_id")
	private int id;
	private String name;
	private int age;
	private float sal;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department dept;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int age, float sal, Department dept) {
		super();
		this.name = name;
		this.age = age;
		this.sal = sal;
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", sal=" + sal + ", dept=" + dept + "]";
	}
	
	
}
