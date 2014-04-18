package ar.com.jengibre.jersey2guice3jpa2.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ar.com.jengibre.jersey2guice3jpa2.model.User;
import ar.com.jengibre.jersey2guice3jpa2.service.UserService;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

   @Inject
   private UserService userService;

   @Path("/get/{id}")
   @GET
   public User getUser(@PathParam("id") long id) {
      return userService.findById(id);
   }

   @Path("/getAll")
   @GET
   public List<User> getAll() {
      return userService.findAll();
   }

   @Path("/get-by-email/{email}")
   @GET
   public User getUser(@PathParam("email") String email) {
      return userService.findByEmail(email);
   }

   @Path("/create")
   @POST
   public User create(@FormParam("username") String username, @FormParam("password") String password,
         @FormParam("email") String email) {
      return userService.create(username, password, email);
   }
}