package ar.com.jengibre.jersey2guice3jpa2.service;

import java.util.List;

import ar.com.jengibre.jersey2guice3jpa2.model.User;

public interface UserService {

   public User create(String username, String password, String email);

   public User findByEmail(String email);

   public User findById(long id);

   public List<User> findAll();
}
