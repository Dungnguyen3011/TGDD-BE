package com.project.tgdd_be.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="tbl_location")
@Entity
@Data
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="location_id")
	private Integer locationId;
	
    @Column(name="location_name")
	private String locationName;
    
    @Column(name="store_id")
	private Integer storeId;
}
