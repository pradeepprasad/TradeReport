package Business_Logic;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Currency;

import org.junit.Test;

import com.pradeep.dailytrade.business.logic.InstructionSettlementCalculator;
import com.pradeep.dailytrade.business.logic.Instructions;
import com.pradeep.dailytrade.business.logic.TradeAction;
import com.pradeep.dailytrade.utility.DummyInstructions;

public class SettlementDateCalculatorTest {

	@Test
	public void test1()throws Exception {
		LocalDate expectedSettlementDate = LocalDate.of(2017,05,29);
		Instructions testInstruction = new Instructions(
				"Company-A", 
				TradeAction.BUY,
				.150,
				Currency.getInstance("SGD"),
				LocalDate.of(2017, 03, 10),
				LocalDate.of(2017, 05, 27),//falls on saturday
				110, 
				1000				
				);
		InstructionSettlementCalculator.calculateSettlementDate(testInstruction) ;
		assertEquals(expectedSettlementDate,testInstruction.getSettlementDate() );
				
	}
	
	@Test
	public void test2()throws Exception {
		LocalDate expectedSettlementDate = LocalDate.of(2017,05,28);
		Instructions testInstruction = new Instructions(
				"Company-A", 
				TradeAction.SALE,
				.150,
				Currency.getInstance("SAR"),//for Arabia Working days
				LocalDate.of(2017, 03, 10),
				LocalDate.of(2017, 05, 26),//falls on Friday
				111, 
				1100				
				);
		InstructionSettlementCalculator.calculateSettlementDate(testInstruction) ;
		assertEquals(expectedSettlementDate,testInstruction.getSettlementDate() );
				
	}
}
