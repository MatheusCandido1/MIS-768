package edu.unlv.mis768.ia5;

public interface UnpaidOrderDAO {
	/**
	 * This method inserts an unpaid order record.
	 * @return True or false
	 */
   public boolean insertUpaidOrder(UnpaidOrder unpaidOrder);
}
