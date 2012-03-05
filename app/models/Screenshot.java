/*
 * Copyright (C) 2011  FoOTOo Lab Harbin Institute of Technology 
 * Project:Void Main's Mobile Workshop
 * Author: Void Main
 */
package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

/**   
 * Screen shots for apps
 * 
 * @Project Void Main's Mobile Workshop
 * @Package models
 * @Class Screenshot
 * @author Void Main
 * @version 1.0
 * @since 1.0
 */

@Entity
public class Screenshot extends Model {
	
	public String name;
	public String path;
	
	@ManyToOne
	public App app;
	
	public Screenshot(App app, String name, String path) {
		this.app = app;
		this.name = name;
		this.path = path;
	}
	
}
