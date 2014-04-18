package ar.com.jengibre.jersey2guice3jpa2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   private String username;

   private String password;

   private String email;

   User() {
   }

   public User(String username, String password, String email) {
      this.username = username;
      this.password = password;
      this.email = email;
   }

   public String getUsername() {
      return username;
   }

   public Long getId() {
      return id;
   }

   @JsonIgnore
   public String getPassword() {
      return password;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
