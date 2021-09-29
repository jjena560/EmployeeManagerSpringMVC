package com.nagarro.employeemanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HR implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "USERNAME")
	private String userId;

	@Column(name = "PASSWORD")
	private String password;

	public HR() {
		super();
	}

	public HR(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	@Override
	public String toString() {
		return "HR [id=" + id + ", userId=" + userId + ", password=" + password + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
