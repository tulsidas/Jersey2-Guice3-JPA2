package ar.com.jengibre.jersey2guice3jpa2.misc;

import javax.inject.Inject;

import com.google.inject.persist.PersistService;

public class JPAInitializer {
   @Inject
   JPAInitializer(PersistService service) {
      service.start();
   }
}