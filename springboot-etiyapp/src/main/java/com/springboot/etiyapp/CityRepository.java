package com.springboot.etiyapp;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

  List<City> findByTitleContaining(String title);
}
