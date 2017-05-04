package net.antra.deptemp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.antra.deotemp.utility.Constants;
import net.antra.deptemp.dao.EmployeeDAO;
import net.antra.deptemp.entity.DeptEmpCode;
import net.antra.deptemp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO empDAO;

	@Override
	public List<Employee> loadEmpBasicInfo() {
		return empDAO.getEmployeeList();
	}


	@Override
	@Transactional
	public void saveEmp(Employee emp,Integer dept_id) {
		if(emp.getStatus() == null){
			DeptEmpCode status = new DeptEmpCode();
			status.setId(Constants.DEFAUL_EMP_STATUS_ID);
			emp.setStatus(status);
		}
		empDAO.save(emp,dept_id);
	}

	@Override
	@Transactional
	public List<Employee> loadEmpDetails() {
		return empDAO.findAllEmployees();
	}
}
