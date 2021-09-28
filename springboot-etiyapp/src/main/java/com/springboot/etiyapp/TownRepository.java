package com.springboot.etiyapp;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TownRepository extends JpaRepository<Town, Long> {

  List<Town> findByTitleContaining(String title);
}
