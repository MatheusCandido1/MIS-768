package edu.unlv.mis768.labwork11;

public class Cube extends Rectangle {

	private double height;
	
	public Cube(double len, double w, double h) {
		super(len, w);
		height = h;
	}
	
	public double getVolume() {
		return getArea() * this.height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
}
