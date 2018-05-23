package dao;

import java.sql.Timestamp;
import java.util.List;

public interface ReimbursementDAO {
	public boolean createNewReimbursement(int requesterEmployeeId, String approvalStatus,
			String descriptionNote, double currencyValue);
	public List<Reimbursement> getReimbursementsByEmployee(int requesterEmpIdInput);
	public List<Reimbursement> getReimbursementsByApproval(String approvalStatusInput);
	public List<Reimbursement> getReimbursementsByEmployeeAndApproval(int requesterEmpIdInput, String approvalStatusInput);
	public List<Reimbursement> getAllReimbursements();
}
