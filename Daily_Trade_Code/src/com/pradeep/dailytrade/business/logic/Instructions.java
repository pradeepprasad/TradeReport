package com.pradeep.dailytrade.business.logic;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

public class Instructions {
	// Define the values of instruction
	private String entity;
	private TradeAction tradeAction;
	private Double agreedFX;
	private Currency currency;
	private LocalDate instructionDate;
	private LocalDate settlementDate;
	private int units;
	private int pricePerunit;

	public Instructions(String entity, TradeAction tradeAction, Double agreedFX,Currency currency, LocalDate instructionDate, LocalDate settlementDate,
			int units, int pricePerunit) {
		// populate values passed on

		this.entity = entity;
		this.tradeAction = tradeAction;
		this.agreedFX = agreedFX;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.units = units;
		this.pricePerunit = pricePerunit;
	}


	// Define the getter and setters
	
	public String getEntity() {
		return entity;
	}

	public TradeAction getTradeAction() {
		return tradeAction;
	}

	public Double getAgreedFX() {
		return agreedFX;
	}

	public Currency getCurrency() {
		return currency;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	public int getUnits() {
		return units;
	}

	public int getPricePerunit() {
		return pricePerunit;
	}
	// Calculate the transaction amount
	public BigDecimal getTradeAmount() {
	//	return (pricePerunit * units * agreedFX);
		return BigDecimal.valueOf( getPricePerunit()* getUnits() * getAgreedFX());
	};
	//the only setter for this class
	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}


    @Override
    public String toString() {
        return entity;
    }

	
}
