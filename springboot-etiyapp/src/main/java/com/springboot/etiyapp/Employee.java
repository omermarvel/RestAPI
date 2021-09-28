package com.springboot.etiyapp;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "branchid")
	private String branchid;


	public Employee() {

	}

	public Employee(String title, String branchid) {
		this.title = title;
		this.branchid = branchid;

	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBranchID() {
		return branchid;
	}

	public void setBranchID(String branchid) {
		this.branchid = branchid;
	}

}
