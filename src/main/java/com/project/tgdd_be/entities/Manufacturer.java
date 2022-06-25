
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
@Table(name="tbl_manufacturer")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Manufacturer {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="manufacturer_id")
	private int manufacturer_id;
    @Column(name="manufacturer_name")
	private String manufacturer_name;
	
    
}
