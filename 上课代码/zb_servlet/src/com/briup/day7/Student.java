package com.briup.day7;

import java.util.Arrays;

public class Student {
	private String name;
	private int age;
	private String gender;
	private String[] addr;
	
	
	public Student() {
	}
	public Student(String name, String[] addr) {
		this.name = name;
		this.addr = addr;
	}
	public Student(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Student(String name, int age, String gender, String[] addr) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.addr = addr;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getAddr() {
		return addr;
	}
	public void setAddr(String[] addr) {
		this.addr = addr;
	}
	public String getAddress(){
		System.out.println("getAddress执行");
		return Arrays.toString(addr);
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gender=" + gender + ", addr=" + Arrays.toString(addr)
				+ "]";
	}
	
}
