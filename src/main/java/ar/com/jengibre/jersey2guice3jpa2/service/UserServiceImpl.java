package ar.com.jengibre.jersey2guice3jpa2.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import ar.com.jengibre.jersey2guice3jpa2.model.User;

public class UserServiceImpl implements UserService {

   @Inject
   private EntityManager em;

   @Override
   public User create(String username, String password, String email) {
      User user = new User(username, password, email);
      em.persist(user);
      return user;
   }

   @Override
   public User findByEmail(String email) {
      try {
         return em.createQuery("from User where email = :email", User.class).setParameter("email", email)
               .getSingleResult();
      }
      catch (NoResultException nre) {
         return null;
      }
   }

   @Override
   public User findById(long id) {
      return em.find(User.class, id);
   }

   @Override
   public List<User> findAll() {
      return em.createQuery("from User", User.class).getResultList();
   }
}