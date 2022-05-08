package com.erdal.hibernate.hibernatehomework;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.erdal.hibernate.hibernatehomework.entity.Employee;

public class CreateEmployeeDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Employee.class).configure()
				.buildSessionFactory();

		Session currentSession = sessionFactory.getCurrentSession();

		try {
			// Create a new employee object and save it to the database
			currentSession.beginTransaction();
			Employee e = new Employee("Erdal","Güzel","DefineX");
			currentSession.persist(e);
			currentSession.getTransaction().commit();

			currentSession.beginTransaction();
			List<Employee> employees = currentSession.createQuery("from Employee")
					.getResultList();
			currentSession.getTransaction().commit();

		} finally {
			currentSession.close();
			sessionFactory.close();
		}

	}
}