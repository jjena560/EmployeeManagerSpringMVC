package com.nagarro.employeemanager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nagarro.employeemanager.main.Main;
import com.nagarro.employeemanager.model.Employee;
import com.nagarro.employeemanager.model.HR;

@Component
@Repository
public class HRDAOImpl {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HR validateHR(HR login) {
		HR hr = null;
		Transaction tx = null;

		try {
			Session session = Main.getFactory().openSession();
			tx = session.beginTransaction();
			hr = (HR) session.createQuery("from HR u where u.userId = :userName")
					.setParameter("userName", login.getUserId()).uniqueResult();
			if (hr != null && hr.getPassword().equals(login.getPassword())) {
				System.out.println("Logged in");
				return hr;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hr;

	}

	public void addEmployee(Employee emp) {
		Transaction tx = null;
		try {
			Session session = Main.getFactory().openSession();
			tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
			session.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		this.hibernateTemplate.save(emp);
	}

	public List<Employee> getAllEmployees() {

		List<Employee> employees = this.hibernateTemplate.loadAll(Employee.class);
		return employees;
	}

	public void deleteById(long empCode) {
		Employee emp = this.hibernateTemplate.load(Employee.class, empCode);
		this.hibernateTemplate.delete(emp);
	}
}
