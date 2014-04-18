Jersey2-Guice3-JPA2
===================

Sample app showcasing Jersey 2, Guice 3, JPA 2 and Jackson 2



Guice needs an HK2 (which is the DI of Jersey) bridge to work, and also to be able to ```@Inject EntityManager``` there is some initialization to make.

Take a look at:
- [ar.com.jengibre.jersey2guice3jpa2.misc.Application](https://github.com/tulsidas/Jersey2-Guice3-JPA2/blob/master/src/main/java/ar/com/jengibre/jersey2guice3jpa2/misc/Application.java)
- [ar.com.jengibre.jersey2guice3jpa2.misc.GuiceModule](https://github.com/tulsidas/Jersey2-Guice3-JPA2/blob/master/src/main/java/ar/com/jengibre/jersey2guice3jpa2/misc/GuiceModule.java)
- [ar.com.jengibre.jersey2guice3jpa2.misc.JPAInitializer](https://github.com/tulsidas/Jersey2-Guice3-JPA2/blob/master/src/main/java/ar/com/jengibre/jersey2guice3jpa2/misc/JPAInitializer.java)
- [web.xml](https://github.com/tulsidas/Jersey2-Guice3-JPA2/blob/master/src/main/webapp/WEB-INF/web.xml)

to see how everything integrates together.

**Note**: You *can't* @Inject an EntityManager in a Jersey Controller, because controllers are managed by Jersey and *not* by Guice, hence it won't have te appropriate interceptors
