package ar.com.jengibre.jersey2guice3jpa2.misc;

import javax.inject.Inject;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import com.google.inject.Guice;

public class Application extends ResourceConfig {

   @Inject
   public Application(ServiceLocator serviceLocator) {
      packages(true, "ar.com.jengibre");

      // guice
      GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);

      GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
      guiceBridge.bridgeGuiceInjector(Guice.createInjector(new GuiceModule()));
   }
}