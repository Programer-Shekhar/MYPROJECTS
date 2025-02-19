package com.nit.service;

import java.util.List;

import com.nit.entity.Employee;

public interface IEmployeeMgmtService {
	
	public Employee saveEmp(Employee emp);
	
	public List<Employee> getAllEmp();
	
	public Employee getEmpById(int id);
	
	public boolean deleteEmp(int id);
}
