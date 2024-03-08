package com.bookshelf.bookstore.config;

import com.bookshelf.bookstore.service.UserService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringJerseyConfig extends ResourceConfig {
    public SpringJerseyConfig() {
        register(UserService.class);
    }
}
