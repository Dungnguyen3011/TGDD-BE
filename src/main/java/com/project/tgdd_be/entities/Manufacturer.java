
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

import lombok.Data;
@Table(name="tbl_manufacturer")
@Entity
@Data
public class Manufacturer {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="manufacturer_id")
	private Integer manufacturerId;
    
    @Column(name="manufacturer_name")
	private String manufacturerName;
	
    @Column(name="status")
	private Boolean status;
    
    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
	private Set<Product> products;
}
