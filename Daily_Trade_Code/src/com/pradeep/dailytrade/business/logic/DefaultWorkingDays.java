package com.pradeep.dailytrade.business.logic;

import java.time.DayOfWeek;

public class DefaultWorkingDays extends WorkingDays{
	//This implementation class override the setup and working day map
	 
	private static DefaultWorkingDays instance = null;
	
	public static DefaultWorkingDays getInstance(){
		// Only one object for this class should exist.
		//Singleton Design Pattern
		if (instance == null){
			return instance = new DefaultWorkingDays();
		}
		else {
			//it means object already exist
			return instance;
		}
		
	}
	
	
	private DefaultWorkingDays(){
		//it will call the super class constructor which will invoke days setup as per default working days. 
		super();
	}
	
	@Override
	protected void setupWorkingDays() {
		// Set the default working days with boolean value 
		//False means not working day
		this.workingDaysMap.put(DayOfWeek.MONDAY, Boolean.TRUE); 
		this.workingDaysMap.put(DayOfWeek.TUESDAY, Boolean.TRUE);
		this.workingDaysMap.put(DayOfWeek.WEDNESDAY, Boolean.TRUE);
		this.workingDaysMap.put(DayOfWeek.THURSDAY, Boolean.TRUE);
		this.workingDaysMap.put(DayOfWeek.FRIDAY, Boolean.TRUE);
		this.workingDaysMap.put(DayOfWeek.SATURDAY, Boolean.FALSE);
		this.workingDaysMap.put(DayOfWeek.SUNDAY, Boolean.FALSE);
	}
	
	
	
	
	
}
