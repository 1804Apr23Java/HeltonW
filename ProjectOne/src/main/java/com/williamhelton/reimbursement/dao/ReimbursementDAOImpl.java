package com.williamhelton.reimbursement.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.williamhelton.reimbursement.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	private String filename = "connection.properties";

	@Override
	public List<Reimbursement> getReimbursementsByEmployee(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementsByApproval(String approvalStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createNewReimbursement(int requesterEmployeeId, String approvalStatus,
			String descriptionNote, double currencyValue) {
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO REIMBURSEMENT (REQUESTER_EMP_ID, APPROVAL_STATUS, DESCRIPTION_NOTE, CURRENCY_VALUE) VALUES (?, ?, ?, ?)";
			p = con.prepareStatement(sql);
			p.setInt(1, requesterEmployeeId);
			p.setString(2, approvalStatus);
			p.setString(3, descriptionNote);
			p.setDouble(4, currencyValue);
			
			int rowCount = p.executeUpdate();
			con.close();
			return (rowCount == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
