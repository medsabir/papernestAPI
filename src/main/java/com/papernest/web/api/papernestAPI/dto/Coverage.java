package com.papernest.web.api.papernestAPI.dto;

public class Coverage{
	private String operateur; 
	private String X; 
	private String Y;
	private boolean twoG; 
	private boolean threeG; 
	private boolean fourG;
	
	public Coverage(String operateur, String x, String y, boolean twoG, boolean treeG, boolean fourG) {
		super();
		this.operateur = operateur;
		X = x;
		Y = y;
		this.twoG = twoG;
		this.threeG = treeG;
		this.fourG = fourG;
	}
	public String getOperateur() {
		return operateur;
	}
	public void setOperateur(String operateur) {
		this.operateur = operateur;
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
	public boolean isTwoG() {
		return twoG;
	}
	public void setTwoG(boolean twoG) {
		this.twoG = twoG;
	}
	public boolean isTreeG() {
		return threeG;
	}
	public void setTreeG(boolean treeG) {
		this.threeG = treeG;
	}
	public boolean isFourG() {
		return fourG;
	}
	public void setFourG(boolean fourG) {
		this.fourG = fourG;
	}
	@Override
	public String toString() {
		return "Coverage [operateur=" + operateur + ", X=" + X + ", Y=" + Y + ", twoG=" + twoG + ", treeG=" + threeG
				+ ", fourG=" + fourG + "]";
	}
}
