package com.hib;

import java.util.Map;

public class Car {

	private int id;
	private String name;
	private String manufacturer;
	
	private Map<String,Part> parts;
	
	
	public Map<String, Part> getParts() {
		return parts;
	}
	public void setParts(Map<String, Part> parts) {
		this.parts = parts;
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
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", manufacturer=" + manufacturer + ", parts=" + parts + "]";
	}
	
}
