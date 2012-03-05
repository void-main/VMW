import models.Developer;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

/*
 * Copyright (C) 2011  FoOTOo Lab Harbin Institute of Technology 
 * Project:Void Main's Mobile Workshop
 * Author: Void Main
 */

/**   
 * Do some init job here.
 * 
 * @Project Void Main's Mobile Workshop
 * @Package 
 * @Class Bootstrap
 * @author Void Main
 * @version 1.0
 * @since 1.0
 */

@OnApplicationStart
public class Bootstrap extends Job {

	public void doJob() {
		if(Developer.count() == 0) {
			Fixtures.loadModels("initial-data.yml");
		}
	}
	
}
