package com.bookshelf.bookstore.service;

import com.bookshelf.bookstore.manager.UserManager;
import com.bookshelf.bookstore.model.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class UserService {

    private UserManager userManager;
    public UserService(){}
    public UserService(UserManager userManager) {
        this.userManager = userManager;
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response registerUser(User user) {
        try {
            userManager.register(user);
            return Response.status(Response.Status.CREATED).entity("User registered successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response loginUser(User user) {
        boolean loginSuccess = userManager.login(user.getUsername(), user.getPassword());
        if (loginSuccess) {
            return Response.ok("User logged in successfully").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
        }
    }
    @GET // Indicates that this method handles HTTP GET requests
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN) // Specifies the MIME media type of the response
    public Response testServer() {
        return Response.ok("Server is working fine").build(); // Returns a success message
    }
}
