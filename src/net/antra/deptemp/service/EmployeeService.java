package net.antra.deptemp.service;

import java.util.List;

import net.antra.deptemp.entity.Employee;

public interface EmployeeService {

	public List<Employee> loadEmpBasicInfo();

	public void saveEmp(Employee emp, Integer dept_id);

	public List<Employee> loadEmpDetails();

}
