package com.nagarro.employeemanager.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nagarro.employeemanager.model.Employee;
import com.nagarro.employeemanager.model.HR;

public class Main {
	public static SessionFactory factory;

	public static SessionFactory getFactory() {
		if (factory == null) {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}

	public static void main(String[] args) {
		try {
			Session session = Main.getFactory().openSession();
			Transaction tx = session.beginTransaction();
//			String uri = "http://localhost:50133/employees";
//			RestTemplate restTemplate = new RestTemplate();
//			String result = restTemplate.getForObject(uri, String.class);
//			Gson gson = new Gson();
//			Type listType = new TypeToken<ArrayList<Employee>>() {
//			}.getType();
//			ArrayList<Employee> emp = new Gson().fromJson(result, listType);
//			for (Employee e : emp) {
//				System.out.println(e.getEmpCode());
//			}

			Employee emp = new Employee(504, "Jyotiprakash Jena", "Barcelona", "jp56@gmail.com", "22Nov2030");

			HR hr = new HR();
			hr.setUserId("Jp");
			hr.setPassword("1234");
//			session.save(hr);
			session.save(emp);
			tx.commit();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
