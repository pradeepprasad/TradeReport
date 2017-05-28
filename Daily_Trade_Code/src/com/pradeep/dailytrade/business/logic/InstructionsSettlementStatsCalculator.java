package com.pradeep.dailytrade.business.logic;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
//This library is required for collector operation like reducing
import static java.util.stream.Collectors.*;

public class InstructionsSettlementStatsCalculator {
//This class is going to calculate the different statistics for report generation
	//Identify type of transactions for statistics.
	final Predicate<Instructions> outGoingPredicate = 
									instruction -> instruction.getTradeAction().equals(TradeAction.BUY);
	
	final Predicate<Instructions> inComingPredicate = 
											instruction -> instruction.getTradeAction().equals(TradeAction.SALE);
	
	public  Map<LocalDate, BigDecimal> generateDailyStatsOutgoing ( Set<Instructions> instructions ){
		//It is important to check to get the correct settlement date as per business logic
		//InstructionSettlementCalculator instructionSettlementCalculator = new InstructionSettlementCalculator();
		//instructionSettlementCalculator.getInstructionSettlementDate(instructions);
	 	//invoke general function for daily stats calculation with predicate for outgoing transactions
		return generateDailyStats(instructions, outGoingPredicate);
	}
	
	public  Map<LocalDate, BigDecimal> generateDailyStatsIncoming ( Set<Instructions> instructions ){
		//It is important to check to get the correct settlement date as per business logic
		//InstructionSettlementCalculator instructionSettlementCalculator = new InstructionSettlementCalculator();
		//instructionSettlementCalculator.getInstructionSettlementDate(instructions);
	 	//invoke general function for daily stats calculation with predicate for incoming transactions
		return generateDailyStats(instructions, inComingPredicate);
	}
	
	private  Map<LocalDate, BigDecimal> generateDailyStats(
            							Set<Instructions> instructions, Predicate<Instructions> predicate)
    {
		//Common function to calculate daily total incoming and outgoing settlement amount based on request made by predicate	
		 return instructions.stream()
 	   //get only those records given as predicate        
				 					.filter(predicate)
       //use collector to get the grouping based on settlement date and trade amount for that date
				 					.collect(groupingBy(Instructions::getSettlementDate,
         		//As we have to add trade amount for particular date and predicate hence do mapping of value
         		//of trade amount by adding it
				 					mapping(Instructions::getTradeAmount,
         		//first parameter of reducing is identity of type value(also for default value)
         		//second parameter of reducing function		
				 					reducing(BigDecimal.ZERO, BigDecimal::add))));	
	}
	
	
	public  Map<LocalDate, LinkedList<Rank>> generateRankStatsIncoming ( Set<Instructions> instructions ){
		//It is important to check to get the correct settlement date as per business logic
		//InstructionSettlementCalculator instructionSettlementCalculator = new InstructionSettlementCalculator();
		//instructionSettlementCalculator.getInstructionSettlementDate(instructions);
	 	//invoke general function for daily stats calculation with predicate for incoming transactions
		return generateDailyRank(instructions, inComingPredicate);
	}

	public  Map<LocalDate, LinkedList<Rank>> generateRankStatsOutGoing ( Set<Instructions> instructions ){
		//It is important to check to get the correct settlement date as per business logic
		//InstructionSettlementCalculator instructionSettlementCalculator = new InstructionSettlementCalculator();
		//instructionSettlementCalculator.getInstructionSettlementDate(instructions);
	 	//invoke general function for daily stats calculation with predicate for incoming transactions
		return generateDailyRank(instructions, outGoingPredicate);
	}
	
    private  Map<LocalDate, LinkedList<Rank>> generateDailyRank(
            Set<Instructions> instructions, Predicate<Instructions> predicate)
    {
    	//Common function to calculate daily total incoming and outgoing settlement amount based on request made by predicate
    	final Map<LocalDate, LinkedList<Rank>> ranking = new HashMap<>();
        instructions.stream()
        	//get only those records given as predicate      	
            .filter(predicate)
          //instructions are grouped as per settlement date and collected in instruction set of filtered instructions      
            .collect(groupingBy(Instructions::getSettlementDate, toSet()))
          //process each record collected    
            .forEach((date, dailyInstructionSet) -> {
            	//generate ranking start from 1   
                final AtomicInteger rank = new AtomicInteger(1);
                //generate ranks 
                // process record collected in set 
                final LinkedList<Rank> ranks = dailyInstructionSet.stream()
                		// sort in descending order 
                    .sorted((a, b) -> b.getTradeAmount().compareTo(a.getTradeAmount()))
                    	// from sorted record set, get rank and entity name 
                    .map(instruction -> new Rank(rank.getAndIncrement(), instruction.getEntity(), date))
                    	// store processed record to linked list collection
                    .collect(toCollection(LinkedList::new));
             //store processed record in form of settlement date and rank linked list individually    
                ranking.put(date, ranks);
                            });
      //store all processed records    
        return ranking;
    }
	
}
