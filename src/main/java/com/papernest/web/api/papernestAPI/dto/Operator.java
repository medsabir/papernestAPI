package com.papernest.web.api.papernestAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Operator {
	
	private boolean twoG;
	private boolean threeG;
	private boolean fourG;
	
	public Operator(boolean twoG, boolean treeG, boolean fourG) {
		super();
		this.twoG = twoG;
		this.threeG = treeG;
		this.fourG = fourG;
	}
	@JsonProperty("2G")
	public boolean isTwoG() {
		return twoG;
	}
	public void setTwoG(boolean twoG) {
		this.twoG = twoG;
	}
	
	@JsonProperty("3G")
	public boolean isTreeG() {
		return threeG;
	}
	public void setTreeG(boolean treeG) {
		this.threeG = treeG;
	}
	
	@JsonProperty("4G")
	public boolean isFourG() {
		return fourG;
	}
	public void setFourG(boolean fourG) {
		this.fourG = fourG;
	}
	@Override
	public String toString() {
		return "Operator [twoG=" + twoG + ", treeG=" + threeG + ", fourG=" + fourG + "]";
	}
	
	

}
