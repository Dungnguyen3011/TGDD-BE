
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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="location_id")
	private int location_id;
    @Column(name="location_name")
	private String location_name;
    @Column(name="store_id")
	private int store_id;
    public Location()
    {

    }
    public Location (int location_id, String location_name, int store_id){
        this.location_id = location_id;
        this.location_name= location_name;
        this.store_id=store_id;
    }
    


    /**
     * @return return the location_id
     */
    public int getLocation_id() {
        return location_id;
    }

    /**
     * @param location_id the location_id to set
     */
    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    /**
     * @return String return the location_name
     */
    public String getLocation_name() {
        return location_name;
    }

    /**
     * @param location_name the location_name to set
     */
    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    /**
     * @return int return the store_id
     */
    public int getStore_id() {
        return store_id;
    }

    /**
     * @param store_id the store_id to set
     */
    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

}
