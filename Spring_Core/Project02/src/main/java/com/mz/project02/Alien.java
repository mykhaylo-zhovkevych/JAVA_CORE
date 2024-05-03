package com.mz.project02;

public class Alien {
	private int age;
	private Computer com;
	
	
	// simple Constructor
		public Alien() {
			System.out.println("Alien Object Created");
		}
	

		
//	public Alien(int age) {
//		super();
//		this.age = age;
//	}



	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("Age Assigned");
		this.age = age;
	}

	
//	public Laptop getLaptop() {
//		return laptop;
//	}
//
//	public void setLaptop(Laptop laptop) {
//		this.laptop = laptop;
//	}
	

	public Computer getCom() {
		return com;
	}



	public void setCom(Computer com) {
		this.com = com;
	}
	
	public void code() {
		System.out.println("im coding...");
		com.compile();
	}
}
