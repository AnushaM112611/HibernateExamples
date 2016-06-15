package com.entities;

public class Circle implements Shape {

	public void getShape() {
		System.out.println("I am circle");
	};
	public static void main(String[] args) {
		Student1 s1 = new Student1();
		s1.createShape();
	}
}


class Triangle implements Shape{
	@Override
	public void getShape() {
	System.out.println("I am Triangle");
	}
}

class Rectangle implements Shape{
	@Override
	public void getShape() {
		System.out.println("I am Rectangle");
	}
}
interface Shape{
	public void getShape();
}
class Student1{
	
	public void createShape(){
		Shape s = new Rectangle();
		s.getShape();
		 
	}
}