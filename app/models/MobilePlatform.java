/*
 * Copyright (C) 2011  FoOTOo Lab Harbin Institute of Technology 
 * Project:Void Main's Mobile Workshop
 * Author: Void Main
 */
package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

/**   
 * Mapping to Platform table, storing possible platforms.
 * For example, android, iOS, Windows Phone 7 or so.
 * 
 * @Project Void Main's Mobile Workshop
 * @Package models
 * @Class MobilePlatform
 * @author Void Main
 * @version 1.0
 * @since 1.0
 */

@Entity
public class MobilePlatform extends Model implements Comparable<MobilePlatform> {
	
	public String name;
	public String path;
	
	public MobilePlatform(String name, String path) {
		this.name = name;
		this.path = path;
	}
	
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(MobilePlatform other) {
		return name.compareTo(other.name);
	}
	
}
