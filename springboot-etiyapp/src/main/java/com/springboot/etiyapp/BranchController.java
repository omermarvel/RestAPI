package com.springboot.etiyapp;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BranchController {

	@Autowired
	BranchRepository branchRepository;

	@GetMapping("/branch")
	public ResponseEntity<List<Branch>> getAllcities(@RequestParam(required = false) String title) {
		try {
			List<Branch> cities = new ArrayList<Branch>();

			if (title == null)
				branchRepository.findAll().forEach(cities::add);
			else
				branchRepository.findByTitleContaining(title).forEach(cities::add);

			if (cities.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(cities, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/branch/{id}")
	public ResponseEntity<Branch> getBranchById(@PathVariable("id") long id) {
		Optional<Branch> branchData = branchRepository.findById(id);

		if (branchData.isPresent()) {
			return new ResponseEntity<>(branchData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/branch")
	public ResponseEntity<Branch> createBranch(@RequestBody Branch branch) {
		try {
			Branch _branch = branchRepository
					.save(new Branch(branch.getTitle(), branch.getTownID()));
			return new ResponseEntity<>(_branch, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/branch/{id}")
	public ResponseEntity<Branch> updateBranch(@PathVariable("id") long id, @RequestBody Branch branch) {
		Optional<Branch> branchData = branchRepository.findById(id);

		if (branchData.isPresent()) {
			Branch _branch = branchData.get();
			_branch.setTitle(branch.getTitle());
			_branch.setTownID(branch.getTownID());
			return new ResponseEntity<>(branchRepository.save(_branch), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/branch/{id}")
	public ResponseEntity<HttpStatus> deleteBranch(@PathVariable("id") long id) {
		try {
			branchRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/branch")
	public ResponseEntity<HttpStatus> deleteAllBranchs() {
		try {
			branchRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}