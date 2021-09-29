package com.nagarro.employeemanager.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nagarro.employeemanager.dao.HRDAOImpl;
import com.nagarro.employeemanager.model.Employee;
import com.nagarro.employeemanager.model.HR;
import com.nagarro.employeemanager.services.HRManager;

@Controller
public class HRController {

	@Autowired
	HRDAOImpl dao;

	@Autowired
	HRManager manager;

	@RequestMapping("/login")
	public void login() {
		System.out.println("Hello");
	}

	@RequestMapping(value = "/hrlogin", method = RequestMethod.POST)
	public ModelAndView validateHR(@RequestParam("userId") String id, @RequestParam("password") String pass,
			Model model) {
		ModelAndView mav = null;
		model.addAttribute("title", "Employees");

		HR newlogin = manager.validateHR(new HR(id, pass));

		if (newlogin != null) {
			mav = new ModelAndView("employeeList");
			String uri = "http://localhost:54512/employees";
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(uri, String.class);
			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<Employee>>() {
			}.getType();
			ArrayList<Employee> employees = new Gson().fromJson(result, listType);
//			List<Employee> employees = dao.getAllEmployees();
//			System.out.println(emp);
//			return result;
//			System.out.println(employees.size());
			model.addAttribute("employees", employees);

		} else {
//			
			System.out.println("Not found");
		}

		return mav;
	}

	@RequestMapping(value = "/editemp/{id}", method = RequestMethod.PUT)
	public String edit(@RequestParam("Employee") Employee emp, Model m) {
		m.addAttribute(emp);
		return "UpdateDetails";
	}

	@RequestMapping(value = "/save")
	public String createOrUpdateEmployee(@RequestParam("empCode") long id, @RequestParam("empName") String name,
			@RequestParam("empLoc") String loc, @RequestParam("empMail") String mail,
			@RequestParam("empDOB") String dob) {
		Employee emp = new Employee(id, name, loc, mail, dob);
		dao.addEmployee(emp);
		return "employeeList";
	}

	@RequestMapping(value = "/addEmployee")
	private String addEmployee() {
		return "addEmployee";
	}

	@RequestMapping(value = "/employees")
	private String getStudentString() {
		return "employeeList";
	}

}
