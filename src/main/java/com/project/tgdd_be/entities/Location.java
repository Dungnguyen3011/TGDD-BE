package com.project.tgdd_be.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="tbl_location")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="location_id")
	private Integer location_id;
	
    @Column(name="location_name")
	private String location_name;
    
    @Column(name="store_id")
	private Integer store_id;
}
