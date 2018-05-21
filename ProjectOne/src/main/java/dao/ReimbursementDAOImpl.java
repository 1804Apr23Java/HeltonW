package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	private String filename = "connection.properties";

	@Override
	public List<Reimbursement> getAllReimbursements() {
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM REIMBURSEMENT";
			p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			List<Reimbursement> results = new ArrayList<>();
			
			while (rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				Timestamp dateTimeStamp = rs.getTimestamp("DATETIMESTAMP");
				int requesterEmpId = rs.getInt("REQUESTER_EMP_ID");
				String approvalStatus = rs.getString("APPROVAL_STATUS");
				int approvalManagerId = rs.getInt("APPROVAL_MANAGER_ID");
				String descriptionNote = rs.getString("DESCRIPTION_NOTE");
				double currencyValue = rs.getDouble("CURRENCY_VALUE");
				Reimbursement reimbursement = new Reimbursement(reimbursementId, dateTimeStamp, requesterEmpId, approvalManagerId,
						approvalStatus, descriptionNote, currencyValue);
				results.add(reimbursement);				
			}
			con.close();
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementsByEmployee(int requesterEmpIdInput) {
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM REIMBURSEMENT WHERE REQUESTER_EMP_ID = ?";
			p = con.prepareStatement(sql);
			p.setInt(1, requesterEmpIdInput);
			ResultSet rs = p.executeQuery();
			List<Reimbursement> results = new ArrayList<>();
			
			while (rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				Timestamp dateTimeStamp = rs.getTimestamp("DATETIMESTAMP");
				int requesterEmpId = rs.getInt("REQUESTER_EMP_ID");
				String approvalStatus = rs.getString("APPROVAL_STATUS");
				int approvalManagerId = rs.getInt("APPROVAL_MANAGER_ID");
				String descriptionNote = rs.getString("DESCRIPTION_NOTE");
				double currencyValue = rs.getDouble("CURRENCY_VALUE");
				Reimbursement reimbursement = new Reimbursement(reimbursementId, dateTimeStamp, requesterEmpId, approvalManagerId,
						approvalStatus, descriptionNote, currencyValue);
				results.add(reimbursement);				
			}
			con.close();
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementsByApproval(String approvalStatusInput) {
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM REIMBURSEMENT WHERE APPROVAL_STATUS = ?";
			p = con.prepareStatement(sql);
			p.setString(1, approvalStatusInput);
			ResultSet rs = p.executeQuery();
			List<Reimbursement> results = new ArrayList<>();
			
			while (rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				Timestamp dateTimeStamp = rs.getTimestamp("DATETIMESTAMP");
				int requesterEmpId = rs.getInt("REQUESTER_EMP_ID");
				String approvalStatus = rs.getString("APPROVAL_STATUS");
				int approvalManagerId = rs.getInt("APPROVAL_MANAGER_ID");
				String descriptionNote = rs.getString("DESCRIPTION_NOTE");
				double currencyValue = rs.getDouble("CURRENCY_VALUE");
				Reimbursement reimbursement = new Reimbursement(reimbursementId, dateTimeStamp, requesterEmpId, approvalManagerId,
						approvalStatus, descriptionNote, currencyValue);
				results.add(reimbursement);				
			}
			con.close();
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
