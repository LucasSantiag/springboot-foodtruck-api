package com.lucas.foodtruck;

import com.google.cloud.datastore.Datastore;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.lucas.foodtruck.models.Ingredient;
import com.lucas.foodtruck.models.Lunch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.naming.spi.ObjectFactory;
import javax.servlet.ServletContextListener;

@SpringBootApplication
public class FoodtruckApplication implements ServletContextListener {

	private Datastore datastore;

	public static void main(String[] args) {
		SpringApplication.run(FoodtruckApplication.class, args);
	}

	public void contextInitialized(ServletContextListener event) {
		ObjectifyFactory factory = getObjectifyFactory();
		ObjectifyService.init(factory);
		doRegister();
	}

	public static void doRegister() {
		ObjectifyService.register(Lunch.class);
		ObjectifyService.register(Ingredient.class);
	}

	private ObjectifyFactory getObjectifyFactory() {
		if (datastore == null) {
			return new ObjectifyFactory();
		}
		return new ObjectifyFactory(datastore);
	}

	public void setDatastore(Datastore service) {
		this.datastore = service;
	}


}
