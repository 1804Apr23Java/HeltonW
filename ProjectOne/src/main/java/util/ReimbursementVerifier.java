package util;

import dao.ReimbursementDAO;
import dao.ReimbursementDAOImpl;

public class ReimbursementVerifier {
	static ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
	
	public static String newReimbursement(int userId, String description, double amount) {
		boolean success = reimbursementDAO.createNewReimbursement(userId, "pending", description, amount);
		if(success) {
			return "SuccessfulTransaction";
		} else {
			return "BadTransaction";
		}
	}
}
