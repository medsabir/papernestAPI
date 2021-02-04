package com.papernest.web.api.papernestAPI.dto;

public class Coordinate {
	
	private int X;
	private int Y;
	
	public Coordinate(int x, int y) {
		super();
		X = x;
		Y = y;
	}

	public Coordinate() {
		super();
	}


	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	@Override
	public String toString() {
		return "Coordinate [X=" + X + ", Y=" + Y + "]";
	}
	
	
	
	

}
