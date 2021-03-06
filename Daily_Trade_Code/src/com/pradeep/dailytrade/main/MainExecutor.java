package com.pradeep.dailytrade.main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.pradeep.dailytrade.business.logic.*;
import com.pradeep.dailytrade.utility.DummyInstructions;

public class MainExecutor {

	public static void main(String[] args) {
	
		// Test while coding 
		// 1. Instruction Class setup done
		// 2. Dummy Instructions setup done
		System.out.println("Hello Word From Main") ;
		//final Set<Instructions> instructions = DummyInstructions.getDummyInstructios();
		Set<Instructions> instructions = DummyInstructions.getDummyInstructios(); 
		 
		instructions
		 .stream()
		 .sorted((inst1,inst2)-> inst1.getEntity().compareTo(inst2.getEntity()))
		 .forEach(inst -> System.out.println(	inst.getEntity() + " " + 
				 								inst.getTradeAction() + " " +
				 								inst.getPricePerunit()  + " " +
				 								inst.getAgreedFX()  + " Trade Amount -" +
				 								inst.getTradeAmount() + " " +
				 								inst.getUnits()  + " " +
				 								inst.getInstructionDate() + " " +
				 								inst.getSettlementDate()  + " " +
				 								inst.getCurrency()
				 		));
		 
		 
		// 3. Working Days setup done		 
		// Check working days setup values 
		// System.out.println(new DefaultWorkingDays().workingDaysMap	);
		// System.out.println(new ArabiaWorkingDays().workingDaysMap	);
		//System.out.println(getInstance(DefaultWorkingDays)); how to invoke public method to get instance if constructor is private
		 DefaultWorkingDays dwd = DefaultWorkingDays.getInstance();
		 ArabiaWorkingDays awd = ArabiaWorkingDays.getInstance();
		 System.out.println("Default Working Days - " + dwd.workingDaysMap);
		 System.out.println("Arabia Working Days  - "  +  awd.workingDaysMap);
		 
	// 4. Report Generator.
		 long startTime, endTime, timeElapsed;
		 startTime = System.nanoTime();
		 //System.out.println("Time now at start - " + System.nanoTime());
		 System.out.println("Time now at start - " + startTime);
		 System.out.println(ReportGenerator.reportGenerator(instructions));
		 endTime = System.nanoTime();
		 //System.out.println("Time now at End - " + System.nanoTime());
		 System.out.println("Time now at End - " + endTime);
		 timeElapsed = endTime - startTime;
		 System.out.println("Time Elapsed - " + timeElapsed);
		 
	/*// 4.1.Calculate Settlement dates(Arabia and Default) as per business logic.
	 	System.out.println("After settlement adjustment") ;
	 	InstructionSettlementCalculator instructionSettlementCalculator = new InstructionSettlementCalculator();
	 	instructionSettlementCalculator
									 	.getInstructionSettlementDate(instructions)
									 	.stream()
										.sorted((inst1,inst2)-> inst1.getEntity().compareTo(inst2.getEntity()))
									 	.forEach(inst -> System.out.println(	
									 				inst.getEntity() + " " + 
													inst.getTradeAction() + " " +
													inst.getPricePerunit()  + " " +
													inst.getAgreedFX()  + " " +
													inst.getTradeAmount() + " " +
													inst.getUnits()  + " " +
													inst.getInstructionDate() + " " +
													inst.getSettlementDate()  + " " +
													inst.getCurrency()
									 								));
		 	
	// 4.2.Amount in USD settled incoming everyday.
	 	System.out.println("After Incoming amount accumalted") ;
	 	InstructionsSettlementStatsCalculator instructionsSettlementStatsCalculator = new InstructionsSettlementStatsCalculator();
	 	Map<LocalDate,BigDecimal> dailyInComing = instructionsSettlementStatsCalculator.generateDailyStatsIncoming(instructions);
	 	// instructionsSettlementStatsCalculator.generateDailyStatsOutgoing(instructions))
	 	dailyInComing.forEach((ld,amount) -> 
	 	System.out.println(ld + " :  " + amount)
	 			);
	 	System.out.println("Generated by Report Generator") ;
	 	ReportGenerator reportGenerator = new ReportGenerator();
	 	System.out.println(reportGenerator.generateDailyIncomingAmount(instructions));
	 	
	 	
	// 4.3.Amount in USD settled outgoing everyday.
	 	System.out.println("After outgoing amount accumalted") ;
	 //	InstructionsSettlementStatsCalculator instructionsSettlementStatsCalculator = new InstructionsSettlementStatsCalculator();
	 	Map<LocalDate,BigDecimal> dailyOutGoing = instructionsSettlementStatsCalculator.generateDailyStatsOutgoing(instructions);
	 	// instructionsSettlementStatsCalculator.generateDailyStatsOutgoing(instructions))
	 	dailyOutGoing.forEach((ld1,amount1) -> 
	 	System.out.println(ld1 + " :  " + amount1)
	 			);
	 	
	 	System.out.println("Generated by Report Generator") ;
	 	System.out.println(reportGenerator.generateDailyOutgoingAmount(instructions));

	 	
	// 4.4.1.Ranking of entities based on incoming amount.
		System.out.println("After Incoming Rank accumalted") ;
	  	Map<LocalDate, LinkedList<Rank>> dailyInComingRank = instructionsSettlementStatsCalculator.generateRankStatsIncoming(instructions);
	 	dailyInComingRank.forEach((ld,amount) -> 
	 	System.out.println(ld + " :  " + amount.getFirst())
	 			);
	 	
		System.out.println("Generated by Report Generator Incoming Rank") ;
	 	System.out.println(reportGenerator.generateDailyIncomingRank(instructions));
	 	
	 	
	// 4.4.2.Ranking of entities based on outgoing amount.
	  	System.out.println("After Outcoming Rank accumalted") ;
	  	Map<LocalDate, LinkedList<Rank>> dailyOutGoingRank = instructionsSettlementStatsCalculator.generateRankStatsOutGoing(instructions);
	  	dailyOutGoingRank.forEach((ld,amount) -> 
	 	System.out.println(ld + " :  " + amount.getFirst())
	 			);

		System.out.println("Generated by Report Generator Outgoing Rank") ;
	 	System.out.println(reportGenerator.generateDailyOutgoingRank(instructions));
	 */
	}

}
