package com.springboot.etiyapp;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "sign")
	private String sign;


	public City() {

	}

	public City(String title, String sign) {
		this.title = title;
		this.sign = sign;

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

	public String getSign() {
		return sign;
	}

	public void setSign(String description) {
		this.sign = description;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", sign=" +sign + "]";
	}
}