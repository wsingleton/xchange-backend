package com.xchange.models;

public class DTO {

	private Long userId;
	private Long companyId;
	
	public DTO() { }
	
	public DTO(Long userId, Long companyId) {
		super();
		this.userId = userId;
		this.companyId = companyId;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	
	
}
