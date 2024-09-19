package org.example.springbootstart;

import org.example.springbootstart.dao.UserDao;
import org.example.springbootstart.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStartApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStartApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createUser();
    }
    private void createUser() {

    }
}
