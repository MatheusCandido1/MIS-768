package edu.unlv.mis768.labwork12;

import java.text.DecimalFormat;

public class Manager extends Staff implements Relatable {
	// the additional field for Manager
	private int level;
	
	// constant to represent the stipend for manager 
	public final double STIPEND = 150;
	
	// getter for level
	public int getLevel() {
		return level;
	}

	/**
	 * The setter for level. It checks the passed value.
	 * If the level is not an legal value, set it to 1
	 * @param l
	 */
	public void setLevel(int l) {
		if(l<1 || l>5)
			l=1;
		level = l;
	}

	/**
	 * This method calculates the salary for manager.
	 * On top of the regular pay as the staff, add the stipend for the manager
	 * The stipend is $150 per level
	 * @return The total salary for Manager
	 */
	public double calcSalary() {
		return super.calcSalary()+STIPEND*level;
	}
	

	public String toString() {

	    DecimalFormat currency = new DecimalFormat("0.00");
	    
		return "Name: " + getName() + "\n"
				+ "Level: " + getLevel() + "\n"
				+ "Salary: $" + currency.format(calcSalary());
	}

	@Override
	public boolean equals(Staff s) {
		if(this.calcSalary() == s.calcSalary())
			return true;
		else 
			return false;
	}

	@Override
	public boolean isGreater(Staff s) {
		if(this.calcSalary() > s.calcSalary())
			return true;
		else 
			return false;
	}

	@Override
	public boolean isLess(Staff s) {
		if(this.calcSalary() < s.calcSalary())
			return true;
		else 
			return false;
	}
}
