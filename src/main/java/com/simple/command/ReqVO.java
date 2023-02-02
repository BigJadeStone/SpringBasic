package com.simple.command;

import java.util.List;

public class ReqVO {
	
	private String name;
	private String age;
	private List<String> inter;
	
	public ReqVO(String name, String age, List<String> inter) {
		super();
		this.name = name;
		this.age = age;
		this.inter = inter;
	}
	

	@Override
	public String toString() {
		return "ReqVO [name=" + name + ", age=" + age + ", inter=" + inter + "]";
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public List<String> getInter() {
		return inter;
	}

	public void setInter(List<String> inter) {
		this.inter = inter;
	}
	
	
	

}
