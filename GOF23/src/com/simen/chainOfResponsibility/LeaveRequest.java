package com.simen.chainOfResponsibility;

public class LeaveRequest {
	String empName;
	int days;
	String reason;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public LeaveRequest(String empName, int days, String reason) {
		super();
		this.empName = empName;
		this.days = days;
		this.reason = reason;
	}
}
