package com.todungnguyen.jpaextracolumn;

import java.util.List;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

	// Create the SessionFactory when you start the application.
	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Initialize the SessionFactory instance.
	 */
	static {
		// Create a Configuration object.
		Configuration config = new Configuration();
		// Configure using the application resource named hibernate.cfg.xml.
		config.configure();
		// Extract the properties from the configuration file.
		Properties prop = config.getProperties();

		// Create StandardServiceRegistryBuilder using the properties.
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(prop);

		// Build a ServiceRegistry
		ServiceRegistry registry = builder.build();
		
		config.addAnnotatedClass(Developer.class);
		config.addAnnotatedClass(DeveloperProject.class);
		config.addAnnotatedClass(Project.class);

		// Create the SessionFactory using the ServiceRegistry
		SESSION_FACTORY = config.buildSessionFactory(registry);
	}

	public static void main(String[] args) {

		// Create a session
		Session session = SESSION_FACTORY.openSession();
		Transaction transaction = null;
		try {
			// Begin a transaction
			transaction = session.beginTransaction();
			Project project = session.find(Project.class, 1);

			System.out.println("Project: " + project.getName());
			
			List<DeveloperProject> devs = project.getDevelopers();

			for (int i = 0; i < devs.size(); i++) {
				DeveloperProject dev = devs.get(i);
				System.out.print("Developer: " + dev.getDeveloper().getName());
				System.out.println(" | Task: " + dev.getTask());
			}
			// Commit the transaction
			transaction.commit();
		} catch (HibernateException ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the session
			session.close();
			SESSION_FACTORY.close();
		}
	}
}
