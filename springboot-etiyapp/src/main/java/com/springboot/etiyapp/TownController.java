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
public class TownController {

	@Autowired
	TownRepository townRepository;

	@GetMapping("/town")
	public ResponseEntity<List<Town>> getAllTowns(@RequestParam(required = false) String title) {
		try {
			List<Town> cities = new ArrayList<Town>();

			if (title == null)
				townRepository.findAll().forEach(cities::add);
			else
				townRepository.findByTitleContaining(title).forEach(cities::add);

			if (cities.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(cities, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/town/{id}")
	public ResponseEntity<Town> getTownById(@PathVariable("id") long id) {
		Optional<Town> townData = townRepository.findById(id);

		if (townData.isPresent()) {
			return new ResponseEntity<>(townData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/town")
	public ResponseEntity<Town> createTown(@RequestBody Town town) {
		try {
			Town _town = townRepository
					.save(new Town(town.getTitle(), town.getCityID()));
			return new ResponseEntity<>(_town, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/town/{id}")
	public ResponseEntity<Town> updateTown(@PathVariable("id") long id, @RequestBody Town town) {
		Optional<Town> townData = townRepository.findById(id);

		if (townData.isPresent()) {
			Town _town = townData.get();
			_town.setTitle(town.getTitle());
			_town.setCityID(town.getCityID());
			return new ResponseEntity<>(townRepository.save(_town), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/town/{id}")
	public ResponseEntity<HttpStatus> deleteTown(@PathVariable("id") long id) {
		try {
			townRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/town")
	public ResponseEntity<HttpStatus> deleteAllCities() {
		try {
			townRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}