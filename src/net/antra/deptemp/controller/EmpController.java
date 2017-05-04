package net.antra.deptemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.antra.deptemp.entity.Department;
//import net.antra.deptemp.entity.Department;
import net.antra.deptemp.entity.Employee;
import net.antra.deptemp.service.DepartmentService;
import net.antra.deptemp.service.EmployeeService;

@Controller
public class EmpController {
	
	@Autowired
	private EmployeeService ems;
	
	@Autowired
	private DepartmentService dpt;
	
	@RequestMapping("/viewEmp")
	public String showEmp(ModelMap model) {
		model.addAttribute("employeeList", ems.loadEmpBasicInfo());
		return "emp";
	}

	@RequestMapping("/manageEmp")
	public String manageEmp(ModelMap model) {
		model.addAttribute("deptList", dpt.loadDeptBasicInfo());
		return "manageEmp";
	}
	
	@RequestMapping(value = "/addEmp",method = RequestMethod.POST)
	public String showAddEmp(@ModelAttribute Employee emp, ModelMap model, @RequestParam Integer dept_id) {
		try{
			System.out.println("before save emp---" +dept_id);
			ems.saveEmp(emp, dept_id);
			System.out.println("after save emp");
			model.addAttribute("success", "Successfully addded an employee.");
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("fail", "Sorry, it failed to add an employee.");
		}
		return "manageEmp";
	}
}
