package org.luojj.dao;

import org.springframework.stereotype.Component;


@Component
public class Dao {
	private String name="aaa";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dao(String name) {
		super();
		this.name = name;
	}
	
	public Dao(){}
	
	

}
