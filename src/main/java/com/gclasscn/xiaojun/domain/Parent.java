package com.gclasscn.xiaojun.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Parent {
	private Long id;
	private String name;
	private String phone;
	private String adders;
	
	private List<Parent> parent;
	
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
	public List<Parent> getParent() {
		return parent;
	}
	public void setParent(List<Parent> parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return "Parent [id=" + id + ", name=" + name + ", phone=" + phone + ", adders=" + adders + ", parent=" + parent
				+ "]";
	}
	
}
