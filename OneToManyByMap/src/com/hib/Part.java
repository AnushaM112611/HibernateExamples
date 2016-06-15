package com.hib;

public class Part {

	private int id;
	private String name;
	private String manufacturedFrom;
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
	public String getManufacturedFrom() {
		return manufacturedFrom;
	}
	public void setManufacturedFrom(String manufacturedFrom) {
		this.manufacturedFrom = manufacturedFrom;
	}
	@Override
	public String toString() {
		return "Part [id=" + id + ", name=" + name + ", manufacturedFrom=" + manufacturedFrom + "]";
	}
	
}
