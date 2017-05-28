package com.pradeep.dailytrade.business.logic;

public enum TradeAction {
	BUY("B"), SALE("S");

	private String tradeType;

	private TradeAction(String tradeType) {
		// enum constructor is called while assigning the constant 
		this.tradeType = tradeType;
	}

	public String getTradeType() {
		return this.tradeType;
	}

	public static TradeAction inputFromString(String tradeType) {
		//this function can be used to intialise trade action with validation of input   
		if (tradeType != null) {
			for (TradeAction tmp : TradeAction.values()) {
				if (tradeType.equalsIgnoreCase(tmp.tradeType)) {
					return tmp;
				}
			}

			throw new IllegalArgumentException("Invalid Trade Type " + tradeType + " found!");
		} else {
			throw new NullPointerException("Null pointer supplied.");
		}

	}//TradeAction
	
}//class ends here