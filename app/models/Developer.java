/*
 * Copyright (C) 2011  FoOTOo Lab Harbin Institute of Technology 
 * Project:Void Main's Mobile Workshop
 * Author: Void Main
 */
package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

/**   
 * Mapping to Developer table in database
 * 
 * @Project Void Main's Mobile Workshop
 * @Package models
 * @Class Developer
 * @author Void Main
 * @version 1.0
 * @since 1.0
 */

@Entity
public class Developer extends Model {
	public String email;
	public String password;
	public String nickname;
	public boolean isAdmin;
	
	public Developer(String email, String password, String nickname) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.isAdmin = true; // default to true
	}
	
	public static Developer connect(String email, String password) {
		return find("byEmailAndPassword", email, password).first();
	}
}
