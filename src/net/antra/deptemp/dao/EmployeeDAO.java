package net.antra.deptemp.dao;

import java.util.List;

import net.antra.deptemp.entity.Employee;

public interface EmployeeDAO {

	List<Employee> getEmployeeList();

	void save(Employee emp,Integer dept_id);

	List<Employee> findAllEmployees();


}
