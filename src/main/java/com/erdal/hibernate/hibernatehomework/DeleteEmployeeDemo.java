package com.erdal.hibernate.hibernatehomework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.erdal.hibernate.hibernatehomework.entity.Employee;

public class DeleteEmployeeDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Employee.class).configure()
				.buildSessionFactory();

		Session currentSession = sessionFactory.getCurrentSession();

		try {
			// Delete an employee from employee table
			currentSession.beginTransaction();
			currentSession.createQuery("delete from Employee e where e.id=1").executeUpdate();
			currentSession.getTransaction().commit();
		} finally {
			currentSession.close();
			sessionFactory.close();
		}

	}

}