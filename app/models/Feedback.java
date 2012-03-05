/*
 * Copyright (C) 2011  FoOTOo Lab Harbin Institute of Technology 
 * Project:Void Main's Mobile Workshop
 * Author: Void Main
 */
package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

/**   
 * User feedbacks for an app.
 * 
 * @Project Void Main's Mobile Workshop
 * @Package models
 * @Class Feedback
 * @author Void Main
 * @version 1.0
 * @since 1.0
 */

@Entity
public class Feedback extends Model {
	
	public String posterName;
	public String posterEmail;
	public Date postAt;
	
	@Lob
	public String postContent;
	
	@ManyToOne
	public App app;
	
	public Feedback(App app, String posterName, String posterEmail, String postContent) {
		this.app = app;
		this.posterName = posterName;
		this.posterEmail = posterEmail;
		this.postContent = postContent;
		this.postAt = new Date();
	}
	
}
