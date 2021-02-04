package com.papernest.web.api.papernestAPI.dto;

public class Coordinate {
	
	private String X;
	private String Y;
	
	public Coordinate(String x, String y) {
		super();
		X = x;
		Y = y;
	}

	public Coordinate() {
		super();
	}


	public String getX() {
		return X;
	}
	public void setX(String x) {
		X = x;
	}
	public String getY() {
		return Y;
	}
	public void setY(String y) {
		Y = y;
	}
	@Override
	public String toString() {
		return "Coordinate [X=" + X + ", Y=" + Y + "]";
	}
	
	
	
	

}
