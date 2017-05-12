package com.ray.restfulboot.been;

/**
 * @author $ Rakesh K Ray
 * @Created May 10, 2017 12:01:34 PM
 */

public class Contact {
	private String name;
	private int id;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact [name=").append(name).append("]");
		return builder.toString();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
