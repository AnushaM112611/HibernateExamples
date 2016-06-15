package com.myhib;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@NamedQueries(
		{
			@NamedQuery(name="findEmployee",
					query="from Employee where name = :name"),
			@NamedQuery(name="findEmployees",
			query="from Employee"),
		}
		)
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name="employee")
public class Employee {

	@Id
	private int id;
	private String name;
	private String designation;
	private String password;
	private Integer phone;
	private String email;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + "]";
	}
	
	
}
