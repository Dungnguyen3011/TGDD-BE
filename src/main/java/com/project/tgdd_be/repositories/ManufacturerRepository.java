package com.project.tgdd_be.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.tgdd_be.entities.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {

}