package com.nagarro.employeemanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empCode;

	@Column(name = "EMPLOYEE_NAME")
	private String empName;

	@Column(name = "LOCATION")
	private String empLoc;

	@Column(name = "MAIL")
	private String empMail;

	@Column(name = "DATE_OF_BIRTH")
	private String empDOB;

	public Employee() {
		super();

	}

	public Employee(long empCode, String empName, String empLoc, String empMail, String empDOB) {
		super();
		this.empCode = empCode;
		this.empName = empName;
		this.empLoc = empLoc;
		this.empMail = empMail;
		this.empDOB = empDOB;
	}

	public long getEmpCode() {
		return empCode;
	}

	public void setEmpCode(long empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpLoc() {
		return empLoc;
	}

	public void setEmpLoc(String empLoc) {
		this.empLoc = empLoc;
	}

	public String getEmpMail() {
		return empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	public String getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(String empDOB) {
		this.empDOB = empDOB;
	}

	@Override
	public String toString() {
		return "Employee [empCode=" + empCode + ", empName=" + empName + ", empLoc=" + empLoc + ", empMail=" + empMail
				+ ", empDOB=" + empDOB + "]";
	}

}
