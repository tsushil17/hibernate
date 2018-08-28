package com.mypackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrieveServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empid = req.getParameter("id");
		int id = Integer.parseInt(empid);
		
		Configuration c = new Configuration();
		c.configure();
		SessionFactory sf = c.buildSessionFactory();
		Session session = sf.openSession();
		Employee updemp = new Employee();
		session.beginTransaction();
		Employee e = (Employee) session.get(Employee.class, id);
		
		PrintWriter pw = resp.getWriter();
		pw.println(e.getName());
		pw.println(e.getAge());
		pw.println(e.getGender());
		pw.println(e.getSalary());
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		
	}
	
}
