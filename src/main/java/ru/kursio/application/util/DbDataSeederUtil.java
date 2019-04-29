package ru.kursio.application.util;

import ru.kursio.application.dao.RoleDao;
import ru.kursio.application.dao.UserDao;
import ru.kursio.application.model.entity.Role;
import ru.kursio.application.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Contains an util to create fill o update the database with the valid categories every time the application runs with
 * default valid info ( in this case, categories ).
 **/

@Component
public class DbDataSeederUtil implements CommandLineRunner {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    @Transactional
    public void run(String... strings) {

        //>ROLES<///////////////////////////

        // SINGLE ROLE CASE
        Role role1 = new Role();
        role1.setRole("ADMIN_SUPPORT");
        Set<Role> hRoles = new HashSet<>();
        hRoles.add(role1);

        // SINGLE ROLE CASE
        Role role2 = new Role();
        Set<Role> hRoles2 = new HashSet<>();
        role2.setRole("CUSTOMER");
        hRoles2.add(role2);

        // DOUBLE ROLE CASE
        Role role3 = new Role();
        Set<Role> hRoles3 = new HashSet<>();
        role3.setRole("TEACHER");
        hRoles3.add(role3);
        hRoles3.add(role2);

        // Drop all Roles
        roleDao.deleteAll();

        // Add our Roles to Database
        List<Role> roles = Arrays.asList(role1, role2, role3);
        roleDao.saveAll(roles);

        // Users
        User user1 = new User();
        user1.setActive(1);
        user1.setUserName("Hubert");
        user1.setPassword(encoder.encode("12345"));
        user1.setRoles(hRoles);

        User user2 = new User();
        user2.setActive(1);
        user2.setUserName("Andres");
        user2.setPassword(encoder.encode("12345"));
        user2.setRoles(hRoles2);

        User user3 = new User();
        user3.setActive(1);
        user3.setUserName("Jaime");
        user3.setPassword(encoder.encode("12345"));
        user3.setRoles(hRoles3);

        // Drop all Users
        userDao.deleteAll();

        // Add our Users to the Database
        List<User> users = Arrays.asList(user1, user2, user3);
        userDao.saveAll(users);
    }
}