package edu.unlv.mis768.labwork9;

public class NameTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FullName myName = new FullName();
		myName.setFirstName("Matheus");
		myName.setMiddleName("Candido");
		myName.setLastName("Carvalho");
		System.out.println(myName.getLength());
		System.out.println(myName);

	}

}
