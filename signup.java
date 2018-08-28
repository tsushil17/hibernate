package com.mypackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class signup extends HttpServlet {
	@SuppressWarnings("deprecation")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String salary = req.getParameter("salary");
		String gender = req.getParameter("gender");
		
		int empage  = Integer.parseInt(age);
		int empsalary = Integer.parseInt(salary);
		int empid = Integer.parseInt(id);
		
		Employee e = new Employee();
		e.setAge(empage);
		e.setGender(gender);
		e.setSalary(empsalary);
		e.setName(name);
		
		Configuration c = new Configuration();
		c.configure();
		SessionFactory sf = c.buildSessionFactory();
		Session s  = sf.openSession();
		s.beginTransaction();
		s.save(e);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
	
	

}
