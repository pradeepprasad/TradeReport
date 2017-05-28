package com.pradeep.dailytrade.utility;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;
import com.pradeep.dailytrade.business.logic.*;

//Create dummy instructions to generate report

public class DummyInstructions {
public static Set <Instructions> getDummyInstructios(){
	return new HashSet<>(Arrays.asList(
			
//			new Instructions("Company-A", "Buy", .150,Currency.getInstance("SGD"),LocalDate.of(2017, 03, 10),
//			new Instructions("Company-A", TradeAction.inputFromString("B"),.150,Currency.getInstance("SGD"),LocalDate.of(2017, 03, 10),
			new Instructions("Company-A", TradeAction.BUY,.150,Currency.getInstance("SGD"),LocalDate.of(2017, 03, 10),
			LocalDate.of(2017, 05, 05), 110, 1000),
			
			new Instructions("Company-A", TradeAction.BUY,.150,Currency.getInstance("SGD"),LocalDate.of(2017, 03, 10),
					LocalDate.of(2017, 05, 10), 111, 11),
				
			new Instructions("Company-B", TradeAction.SALE, .50,Currency.getInstance("AED"), LocalDate.of(2017, 03, 10),
					LocalDate.of(2017, 05, 12), 113, 12),
			
			new Instructions("Company-C", TradeAction.BUY, .80,Currency.getInstance("SGD"), LocalDate.of(2017, 03, 10),
					LocalDate.of(2017, 05, 19), 211, 13),
			
			new Instructions("Company-D", TradeAction.SALE, .30,Currency.getInstance("AED"), LocalDate.of(2017, 03, 10),
					LocalDate.of(2017, 05, 26), 212, 14),
			
			new Instructions("Company-D", TradeAction.SALE, .30,Currency.getInstance("SAR"), LocalDate.of(2017, 03, 10),
					LocalDate.of(2017, 05, 26), 213, 15),
			
			new Instructions("Company-E", TradeAction.BUY, .90,Currency.getInstance("SGD"), LocalDate.of(2017, 03, 10),
					LocalDate.of(2017, 05, 07), 214, 16)
			));											}//Arrays ends here
}
