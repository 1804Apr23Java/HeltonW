package util;

import dao.ReimbursementDAO;
import dao.ReimbursementDAOImpl;

public class ReimbursementVerifier {
	static ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
	
	public static String newReimbursement(int userId, String description, double amount) {
		if(reimbursementDAO.createNewReimbursement(userId, "pending", description, amount)) {
			return "SuccessfulTransaction";
		} else {
			return "BadTransaction";
		}
	}
}
