package ar.com.jengibre.jersey2guice3jpa2.misc;

import ar.com.jengibre.jersey2guice3jpa2.service.UserService;
import ar.com.jengibre.jersey2guice3jpa2.service.UserServiceImpl;

import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;

public class GuiceModule extends ServletModule {

   @Override
   protected void configureServlets() {
      // start the JPA service
      bind(JPAInitializer.class).asEagerSingleton();

      // PersistFilter
      filter("/*").through(PersistFilter.class);

      // jpa + guice
      install(new JpaPersistModule("persistenceUnit")); // same as persistence.xml

      // Guice bindings
      bind(UserService.class).to(UserServiceImpl.class);
   }
}