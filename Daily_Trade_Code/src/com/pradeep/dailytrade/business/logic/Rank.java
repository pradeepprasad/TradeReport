package com.pradeep.dailytrade.business.logic;

import java.time.LocalDate;

public class Rank {
//this class will hold the ranking of entity
	//calculated rank, name of entity and date of transactions.
	private int rank;
	private String entity;  
	private LocalDate date;
	
	
	
	public Rank(int rank,String entity,LocalDate date ){
		this.rank = rank;
		this.entity = entity;
		this.date = date;
	}

	public boolean equals (Object obj){
		
		final Rank other = (Rank) obj;
		//check if all three attributes are matching
		return(
				this.getRank()== other.getRank()&&
				this.getDate().equals(other.getRank()) &&
				this.getEntity().equals(other.getRank())
				);
	}
	
	public String toString(){
		//format rank and entity 
		return ("(" + getRank()+ ")" + getEntity() );
	}
	
	//Getters for each private variable.
	public int getRank() {
		return rank;
	}

	public String getEntity() {
		return entity;
	}

	public LocalDate getDate() {
		return date;
	}
	
	
	
	
	
}
