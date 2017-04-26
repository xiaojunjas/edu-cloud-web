package com.gclasscn.xiaojun.domain;

public class Parent {
	private Long id;
	private String name;
	private String phone;
	private String adders;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdders() {
		return adders;
	}
	public void setAdders(String adders) {
		this.adders = adders;
	}
	@Override
	public String toString() {
		return "Parent [id=" + id + ", name=" + name + ", phone=" + phone + ", adders=" + adders + "]";
	}
	
}
