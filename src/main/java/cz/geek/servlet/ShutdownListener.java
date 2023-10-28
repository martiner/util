package cz.geek.servlet;

import java.beans.Introspector;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ShutdownListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();

		Enumeration<Driver> drivers = DriverManager.getDrivers();
		ArrayList<Driver> driversToUnload = new ArrayList<Driver>();
		while (drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			ClassLoader classLoader = driver.getClass().getClassLoader();
			if (classLoader != null && classLoader.equals(getClass().getClassLoader())) {
				driversToUnload.add(driver);
			}
		}
		for (Driver driver: driversToUnload) {
			ctx.log("Deregistering driver " + driver);
			try {
				DriverManager.deregisterDriver(driver);
			} catch (SQLException e) {
				ctx.log("Exception deregistering driver", e);
			}
		}

		ctx.log("Flushing Bean Introspector caches");
		Introspector.flushCaches();
	}

	public void contextInitialized(ServletContextEvent sce) {
	}

}
