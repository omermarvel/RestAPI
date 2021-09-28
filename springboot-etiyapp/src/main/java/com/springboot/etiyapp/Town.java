package com.springboot.etiyapp;

import javax.persistence.*;

@Entity
@Table(name = "towns")
public class Town {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "cityid")
	private String cityid;


	public Town() {

	}

	public Town(String title, String cityid) {
		this.title = title;
		this.cityid = cityid;

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

	public String getCityID() {
		return cityid;
	}

	public void setCityID(String cityid) {
		this.cityid = cityid;
	}

}