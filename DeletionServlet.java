package com.mypackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empid = req.getParameter("id");
		int id = Integer.parseInt(empid);
		
		Configuration c = new Configuration();
		c.configure();
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Employee deleteemp = new Employee();
		s.beginTransaction();
		deleteemp.setId(id);		
		s.delete(deleteemp);
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}

}
