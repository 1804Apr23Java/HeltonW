package com.williamhelton.reimbursement.dao;

import java.sql.Timestamp;

public class Reimbursement {
    private int reimbursementId;
	private Timestamp dateTimeStamp;
	private int requesterEmployeeId;
	private String approvalStatus;
	private int approvalManagerId;
	private String descriptionNote;
	private float currencyValue;
	
	//with no approvalManagerId
	public Reimbursement(int reimbursementId, Timestamp dateTimeStamp, int requesterEmployeeId, String approvalStatus,
			String descriptionNote, float currencyValue) {
		super();
		this.reimbursementId = reimbursementId;
		this.dateTimeStamp = dateTimeStamp;
		this.requesterEmployeeId = requesterEmployeeId;
		this.approvalStatus = approvalStatus;
		this.descriptionNote = descriptionNote;
		this.currencyValue = currencyValue;
		
		this.approvalManagerId = 0;
	}

	//with approvalManagerId
	public Reimbursement(int reimbursementId, Timestamp dateTimeStamp, int requesterEmployeeId, int approvalManagerId,
			String approvalStatus, String descriptionNote, float currencyValue) {
		super();
		this.reimbursementId = reimbursementId;
		this.dateTimeStamp = dateTimeStamp;
		this.requesterEmployeeId = requesterEmployeeId;
		this.approvalStatus = approvalStatus;
		this.descriptionNote = descriptionNote;
		this.currencyValue = currencyValue;
	}
	
	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public Timestamp getDateTimeStamp() {
		return dateTimeStamp;
	}

	public void setDateTimeStamp(Timestamp dateTimeStamp) {
		this.dateTimeStamp = dateTimeStamp;
	}

	public int getRequesterEmployeeId() {
		return requesterEmployeeId;
	}

	public void setRequesterEmployeeId(int requesterEmployeeId) {
		this.requesterEmployeeId = requesterEmployeeId;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getDescriptionNote() {
		return descriptionNote;
	}

	public void setDescriptionNote(String descriptionNote) {
		this.descriptionNote = descriptionNote;
	}

	public float getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(float currencyValue) {
		this.currencyValue = currencyValue;
	}

	public int getApprovalManagerId() {
		return approvalManagerId;
	}

	public void setApprovalManagerId(int approvalManagerId) {
		this.approvalManagerId = approvalManagerId;
	}
	
}
