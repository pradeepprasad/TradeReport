package com.pradeep.dailytrade.business.logic;

import java.time.DayOfWeek;

public class ArabiaWorkingDays extends WorkingDays {
//Set working days for Arabia
//This implementation class override the setup and working day map
 
		private static ArabiaWorkingDays instance = null;
		
		public static ArabiaWorkingDays getInstance(){
			//Only one object for this class should exist.
			//Singleton Design Pattern
			if (instance == null){
				return instance = new ArabiaWorkingDays();
			}
			else {
				//it means object already exist
				return instance;
			}
			
		}
				
		private ArabiaWorkingDays(){
			//it will call the super class constructor which will invoke days setup as per Arabia working days. 
			super();
		}
		
		@Override
		protected void setupWorkingDays() {
			// Set the default working days with boolean value 
			//False means holidays
			this.workingDaysMap.put(DayOfWeek.MONDAY, Boolean.TRUE); 
			this.workingDaysMap.put(DayOfWeek.TUESDAY, Boolean.TRUE);
			this.workingDaysMap.put(DayOfWeek.WEDNESDAY, Boolean.TRUE);
			this.workingDaysMap.put(DayOfWeek.THURSDAY, Boolean.TRUE);
			this.workingDaysMap.put(DayOfWeek.FRIDAY, Boolean.FALSE);
			this.workingDaysMap.put(DayOfWeek.SATURDAY, Boolean.FALSE);
			this.workingDaysMap.put(DayOfWeek.SUNDAY, Boolean.TRUE);
		}

}
