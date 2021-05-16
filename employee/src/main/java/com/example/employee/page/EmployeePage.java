package com.example.employee.page;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class EmployeePage {
	private int pageNumber;
	private int pageSize;
	private Sort.Direction sortDirection =Sort.Direction.ASC;
	private String sortBy="lastName";
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Sort.Direction getSortDirection() {
		return sortDirection;
	}
	public void setSortDirection(Sort.Direction sortDirection) {
		this.sortDirection = sortDirection;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public EmployeePage(int pageNumber, int pageSize, Direction sortDirection, String sortBy) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.sortDirection = sortDirection;
		this.sortBy = sortBy;
	}
	public EmployeePage() {
		super();
	}
	
}
