package com.pradeep.dailytrade.business.logic;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class ReportGenerator {
//this class will generate all kind of reports based on processing done by other classes.
	//provision for storing the report content and other values.
	private static StringBuilder stringBuilder = new StringBuilder();
	private static InstructionsSettlementStatsCalculator instructionsSettlementStatsCalculator = new InstructionsSettlementStatsCalculator();
	private static Map<LocalDate,BigDecimal> dailyInComing ;
	private static Map<LocalDate,BigDecimal> dailyOutGoing ;
	private static Map<LocalDate, LinkedList<Rank>> dailyInComingRank ;
	private static Map<LocalDate, LinkedList<Rank>> dailyOutGoingRank ;
 	
 	 	
 	public static String reportGenerator(Set<Instructions> instructions ){
		//Generate all reports
		
		 generateDailyOutgoingAmount(instructions);
		 generateDailyIncomingAmount(instructions);
		 generateDailyIncomingRank(instructions);
		 generateDailyOutgoingRank(instructions);
		
		 return stringBuilder.toString();
	}
 	
 	private static String generateDailyIncomingAmount(Set<Instructions> instructions ){
		//Generate report for daily incoming amount
		//populate the headers report.
		stringBuilder.append("--------------Daily Incoming Values-------\n");
		stringBuilder.append("Date                   Amount             \n");
		dailyInComing = instructionsSettlementStatsCalculator.generateDailyStatsIncoming(instructions);
		//populate the values for report.
		dailyInComing.forEach((date,amount) -> 
			stringBuilder.append(date+"              "+amount + "\n")
		 			);
			
		//return back the report string.	
		return stringBuilder.toString();
		
	}
	
 	private static String generateDailyOutgoingAmount(Set<Instructions> instructions){
		//Generate report for daily outgoing amount
				//populate the headers report.
				stringBuilder.append("--------------Daily Outgoing Values-------\n");
				stringBuilder.append("Date                   Amount             \n");
				dailyOutGoing = instructionsSettlementStatsCalculator.generateDailyStatsOutgoing(instructions);
				//populate the values for report.
				dailyOutGoing.forEach((date,amount) -> 
					stringBuilder.append(date+"              "+amount + "\n")
				 			);
					
				//return back the report string.	
				return stringBuilder.toString();
		
	}
	
 	private static String generateDailyIncomingRank(Set<Instructions> instructions){
		
		//Generate report for daily incoming rank
		//populate the headers report.
		stringBuilder.append("--------------Daily Incoming Rank-------\n");
		stringBuilder.append("Date                   Rank         Entity    \n");
		dailyInComingRank = instructionsSettlementStatsCalculator.generateRankStatsIncoming(instructions);
		//populate the values for report.
		for(LocalDate date: dailyInComingRank.keySet()){
			for(Rank rank : dailyInComingRank.get(date)){
				stringBuilder
				      .append(rank
				    		  .getDate()
				    		           +"              " + rank
				    		                          .getRank()
				    		                               +"           "+rank.
				    		                                        getEntity()+ "\n");
			}
		}
		
		return stringBuilder.toString();
		
	}
	
 	private static String generateDailyOutgoingRank(Set<Instructions> instructions){
		//Generate report for daily outgoing rank
				//populate the headers report.
				stringBuilder.append("--------------Daily Outgoing Rank-------\n");
				stringBuilder.append("Date                   Rank         Entity    \n");
				dailyOutGoingRank = instructionsSettlementStatsCalculator.generateRankStatsOutGoing(instructions);
				//populate the values for report.
				for(LocalDate date: dailyOutGoingRank.keySet()){
					for(Rank rank : dailyOutGoingRank.get(date)){
						stringBuilder
						      .append(rank
						    		  .getDate()
						    		           +"              " + rank
						    		                          .getRank()
						    		                               +"           "+rank.
						    		                                        getEntity()+ "\n");
					}
				}
				
				return stringBuilder.toString();
		
	}
	 	
	
	
}
