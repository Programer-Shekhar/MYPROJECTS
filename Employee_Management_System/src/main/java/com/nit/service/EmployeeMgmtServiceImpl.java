package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.nit.entity.Employee;
import com.nit.repository.IEmployeeRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public Employee saveEmp(Employee emp) {
		Employee newEmp = empRepo.save(emp);
		return newEmp;
	}
	
	
	
	@Override
	public List<Employee> getAllEmp() {
		return empRepo.findAll();
	}
	
	@Override
	public Employee getEmpById(int id) {
		
		return empRepo.findById(id).get();
	}

	@Override
	public boolean deleteEmp(int id) {
		Employee deleteEmp = empRepo.findById(id).get();
		
		if(deleteEmp != null) {
			empRepo.delete(deleteEmp);
			
			return true;
		}
		return false;
	}
	
	public void removeSessionMessage() {
		HttpSession session =  ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
	
		session.removeAttribute("msg");
	}
}
