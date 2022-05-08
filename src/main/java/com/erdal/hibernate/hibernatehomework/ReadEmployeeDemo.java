package com.erdal.hibernate.hibernatehomework;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.erdal.hibernate.hibernatehomework.entity.Employee;

public class ReadEmployeeDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Employee.class).configure()
				.buildSessionFactory();

		Session currentSession = sessionFactory.getCurrentSession();

		try {
			// Read employee table
			currentSession.beginTransaction();
			// List<Employee> employees = currentSession.createQuery("from Employee e where
			// e.id=3").getResultList();
			List<Employee> employees = currentSession.createQuery("from Employee e where e.company='Microsoft'")
					.getResultList();
			display(employees);
			currentSession.getTransaction().commit();
		} finally {
			currentSession.close();
			sessionFactory.close();
		}

	}

	public static void display(List<Employee> employees) {
		for (Employee e : employees) {
			System.out.println(e.getFirstName() + " " + e.getLastName() + " " + e.getCompany());
		}
	}
}