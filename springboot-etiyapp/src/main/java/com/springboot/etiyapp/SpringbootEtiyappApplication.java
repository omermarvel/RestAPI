package com.springboot.etiyapp;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringbootEtiyappApplication {
	public static ArrayList<Book> listBook=new ArrayList<Book>(); 
	public static void main(String[] args) {
		 
		listBook.add(new Book(1,"IT","Stephen King"));
		listBook.add(new Book(2,"Under","Stephen King"));  
		listBook.add(new Book(3,"Him","Stephen King"));  
		SpringApplication.run(SpringbootEtiyappApplication.class, args);


	}
	public static ArrayList<Book> getListBook() {
		return listBook;
	}
	public static void setListBook(ArrayList<Book> listBook) {
		SpringbootEtiyappApplication.listBook = listBook;
	}

}

