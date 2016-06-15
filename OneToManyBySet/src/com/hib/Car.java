package com.hib;

import java.util.List;
import java.util.Set;

public class Car {

	private int id;
	private String name;
	private String manufacturer;
	
	private Set<Part> parts;
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
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Set<Part> getParts() {
		return parts;
	}
	public void setParts(Set<Part> parts) {
		this.parts = parts;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", manufacturer=" + manufacturer + ", parts=" + parts + "]";
	}
	
}
