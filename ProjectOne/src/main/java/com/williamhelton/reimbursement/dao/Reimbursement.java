package com.williamhelton.reimbursement.dao;

import java.sql.Timestamp;

public class Reimbursement {
    private int reimbursementId;
	private Timestamp dateTimeStamp;
	private int requesterEmployeeId;
	private String approvalStatus;
	private String descriptionNote;
	private float currencyValue;
}
