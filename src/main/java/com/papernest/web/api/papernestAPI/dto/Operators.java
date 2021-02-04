package com.papernest.web.api.papernestAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Operators {
	
	private Operator Orange;
	private Operator SFR;
	private Operator Free;
	private Operator Bouygue;
	
	@JsonProperty("Orange")
	public Operator getOrange() {
		return Orange;
	}
	public void setOrange(Operator orange) {
		Orange = orange;
	}
	@JsonProperty("SFR")
	public Operator getSFR() {
		return SFR;
	}
	public void setSFR(Operator sFR) {
		SFR = sFR;
	}
	@JsonProperty("Free")
	public Operator getFree() {
		return Free;
	}
	public void setFree(Operator free) {
		Free = free;
	}
	@JsonProperty("Bouygue")
	public Operator getBouygue() {
		return Bouygue;
	}
	public void setBouygue(Operator bouygue) {
		Bouygue = bouygue;
	}
	@Override
	public String toString() {
		return "Operators [Orange=" + Orange + ", SFR=" + SFR + ", Free=" + Free + ", Bouygue=" + Bouygue + "]";
	}
	
	
	

}
