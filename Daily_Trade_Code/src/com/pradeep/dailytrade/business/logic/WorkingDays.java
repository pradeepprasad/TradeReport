package com.pradeep.dailytrade.business.logic;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class WorkingDays implements IWorkingDays {

	//Working days will be set by implementing type of class.
	//protected Map<DayOfWeek, Boolean> workingDaysMap = new HashMap<>();
	public Map<DayOfWeek, Boolean> workingDaysMap = new HashMap<>();
	protected abstract void setupWorkingDays();
	
	public WorkingDays(){
		//Invoke implemented method as per working days setup of implementing class.
		setupWorkingDays();
	}
	
	public LocalDate findWorkingDate(LocalDate date){
		//Now check here if object is initialized. 
		if (workingDaysMap.values().stream().noneMatch(p -> p)){
			// inform the calling object.
			return null;
		}
		//Get the working date 
		return findAvailableWorkingDate(date);
	}
	
	public LocalDate findAvailableWorkingDate(LocalDate date){
		//Convert date to day of week.
		  DayOfWeek day = date.getDayOfWeek();
		  
		if (workingDaysMap.get(day)){
			// inform the calling object that date is working date.
			return date;
		}
		else {
		
			//Check the next the working date by invoking the function recursively 
			return findAvailableWorkingDate(date.plusDays(1));
			
		}
		
	}

	
}
