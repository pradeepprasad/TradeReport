package com.pradeep.dailytrade.business.logic;

import java.time.LocalDate;

public interface IWorkingDays {
//Basic attribute and behavior for finding the working days
	    LocalDate findWorkingDate(LocalDate date);
		
}
