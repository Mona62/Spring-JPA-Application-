package net.antra.deptemp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import net.antra.deptemp.entity.Department;
import net.antra.deptemp.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Employee> getEmployeeList() {
		Query query = em.createQuery("select DISTINCT OBJECT(e) from Employee e ");
		return query.getResultList();
	}

	@Override
	public void save(Employee emp,Integer dept_id) {
	
	emp.setDepartment(em.find(Department.class, dept_id));
	System.out.println(emp.toString());
	em.persist(emp);
	}

	@Override
	public List<Employee> findAllEmployees() {
		Query query = em.createQuery("select DISTINCT OBJECT(e) from Employee e JOIN FETCH d.deptList");
		return query.getResultList();
	}
}
