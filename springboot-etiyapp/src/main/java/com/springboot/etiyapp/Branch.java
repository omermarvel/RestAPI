package com.springboot.etiyapp;

import javax.persistence.*;

@Entity
@Table(name = "branchs")
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "townid")
	private String townid;


	public Branch() {

	}

	public Branch(String title, String townid) {
		this.title = title;
		this.townid = townid;

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

	public String getTownID() {
		return townid;
	}

	public void setTownID(String townid) {
		this.townid = townid;
	}

}
