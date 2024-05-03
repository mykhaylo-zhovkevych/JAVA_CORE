package com.mz.project01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// this simply indicates to the spring that she is responsible for this class and objects
@Component
public class Alien {
	
	// this means this object will be created by the spring
	@Autowired
	Lapop lap;
	// to be able to execute this code by main it must be first instantiated 
	// the idea is to create this object by the spring itself
	public void code() {
		lap.compile();
	}

}
