/*
 * Copyright (C) 2011  FoOTOo Lab Harbin Institute of Technology 
 * Project:Void Main's Mobile Workshop
 * Author: Void Main
 */
package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

/**
 * Application table
 * 
 * contains a foreign key - the develoer that creates this app
 * 
 * @Project Void Main's Mobile Workshop
 * @Package models
 * @Class App
 * @author Void Main
 * @version 1.0
 * @since 1.0
 */

@Entity
public class App extends Model {

	public String appName;
	public Date creationTime;
	public String downloadLink;
	public int projectStatus;
	public String projectLink;
	public String shortDescription;

	@Lob
	public String detailedDescription;

	@ManyToOne
	public Developer developer;
	
	@OneToMany(mappedBy="app", cascade=CascadeType.ALL)
	public List<Feedback> feedbacks;
	
	@OneToMany(mappedBy="app", cascade=CascadeType.ALL)
	public List<Screenshot> screenshots;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	public Set<MobilePlatform> supportedPlatforms;

	public App(Developer developer, String appName, String downloadLink,
			int projectStatus, String projectLink, String shortDescription,
			String detailedDescription) {
		this.appName = appName;
		this.creationTime = new Date();
		this.downloadLink = downloadLink;
		this.projectStatus = projectStatus;
		this.projectLink = projectLink;
		this.shortDescription = shortDescription;
		this.detailedDescription = detailedDescription;
		this.developer = developer;
		
		this.feedbacks = new ArrayList<Feedback>();
		this.screenshots = new ArrayList<Screenshot>();
		this.supportedPlatforms = new TreeSet<MobilePlatform>();
	}
	
	public App addFeedback(String name, String email, String content) {
		Feedback feedback = new Feedback(this, name, email, content).save();
		this.feedbacks.add(feedback);
		this.save();
		return this;
	}
	
	public App addScreenshot(String name, String path) {
		Screenshot screenshot = new Screenshot(this, name, path).save();
		this.screenshots.add(screenshot);
		this.save();
		return this;
	}
	
	public App addSupportPlatform(MobilePlatform platform) {
		supportedPlatforms.add(platform);
		return this;
	}
}
