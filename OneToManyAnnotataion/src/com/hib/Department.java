package com.hib;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class Department {

	@Id
	@GeneratedValue
	@Column(name="dept_id")
	private int id;
	private String name;
	
	@OneToMany(mappedBy="dept")
	private Set<Employee> employees;
	
	
	public Department(int id, String name, Set<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.employees = employees;
	}
	public Department() {
		// TODO Auto-generated constructor stub
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
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employees=" + employees + "]";
	}
	
}
