package com.telekha.empinfo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Leaverequest {
	
	@Id
	private String id;
	
	private String createdid;
	private String createdname;
	private String empid;
    private String fromdate;
    private String todate;
    private String reason;
	private EmployeeReport reportusers;
	private Date createTS;
    private Date updateTS;

	public String getCreatedid() {
		return createdid;
	}
	public String getCreatedname() {
		return createdname;
	}
	public Date getCreateTS() {
		return createTS;
	}
	public Date getUpdateTS() {
		return updateTS;
	}
	public void setCreatedid(String createdid) {
		this.createdid = createdid;
	}
	public void setCreatedname(String createdname) {
		this.createdname = createdname;
	}
	public void setCreateTS(Date createTS) {
		this.createTS = createTS;
	}
	public void setUpdateTS(Date updateTS) {
		this.updateTS = updateTS;
	}
	public String getId() {
		return id;
	}
	public String getEmpid() {
		return empid;
	}
	public String getFromdate() {
		return fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public String getReason() {
		return reason;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public EmployeeReport getReportusers() {
		return reportusers;
	}
	public void setReportusers(EmployeeReport reportusers) {
		this.reportusers = reportusers;
	}

}
