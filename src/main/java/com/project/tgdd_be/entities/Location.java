package com.project.tgdd_be.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    
    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    @JsonManagedReference
	private Set<Store> stores;
}
