package com.pradeep.dailytrade.business.logic;

import java.time.LocalDate;
import java.util.Currency;
import java.util.Set;

public class InstructionSettlementCalculator {
	
	/*This class validate the input instruction to check if it is Arabia or default
	Then check if instruction falls on holiday as per working day strategy
	if this is the case then gets the next working date for given instruction.
	1.Receive set of instruction mix of all kind of instruction
	2.Find out type of instruction day mechanism
	3.Check if instruction requires new settlement date
	4.set the new settlement date
	*/	
	
	public Set<Instructions> getInstructionSettlementDate(Set<Instructions> instructions){
		//calculate the settlement date as per working day mechanism
		instructions.forEach(InstructionSettlementCalculator::calculateSettlementDate);
		// pass back all instructions with correct settlement date
		return instructions;
	}
	public static Instructions calculateSettlementDate(Instructions instruction){
		//currency of current instruction decides the working date strategy
		IWorkingDays workingDateStrategy = getInstructionStrategy(instruction.getCurrency());
		//now find the appropriate settlement date if required
		LocalDate newSettlementDate =
		workingDateStrategy.findWorkingDate(instruction.getSettlementDate());
		//now set the appropriate settlement date if required 
		if (newSettlementDate != null){
			instruction.setSettlementDate(newSettlementDate);
		}
		
		//instruction with correct settlement is being returned. 
		return instruction;
		
	}
	
	public static IWorkingDays getInstructionStrategy(Currency currency){
		//get the appropriate working date mechanism based on currency
		
		  
		if ((currency.getCurrencyCode().equals("AED" )) ||
		    (currency.getCurrencyCode().equals("SAR" ))){
			return  ArabiaWorkingDays.getInstance();
		}
		else{
			return  DefaultWorkingDays.getInstance();
		}
	}
}
