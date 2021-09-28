package com.springboot.etiyapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksRestApi {
	
	@GetMapping("/books")
	public List<Book> getAllBooks(@RequestParam(value = "id", defaultValue = "0") String id){
		return getRequestBook(id);
	}
	public List<Book> getRequestBook(String id){
		return Arrays.asList(new Book(Integer.parseInt(id),getBookbyID(Integer.parseInt(id),1),getBookbyID(Integer.parseInt(id),2)));
	}
	public String getBookbyID(int id, int parameter) {
		for (int i = 0; i < SpringbootEtiyappApplication.getListBook().size(); i++) { 		       
	          if(SpringbootEtiyappApplication.getListBook().get(i).getId()==id) {
	        	  if(parameter==1) {
	        		  return SpringbootEtiyappApplication.getListBook().get(i).getName();
	        	  }
	        	  else {
	        		  return SpringbootEtiyappApplication.getListBook().get(i).getAuthor();
	        	  }
	          }
	      } 
		return "Undefined";
	}
	@GetMapping("/books/{id}")
	public List<Book> getAllBooks(@PathVariable(value = "id") int bookId){
		return Arrays.asList(new Book(bookId,getBookbyID(bookId,1),getBookbyID(bookId,2)));
	}

}
