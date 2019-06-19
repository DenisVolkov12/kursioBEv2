package ru.kursio.application.util;

import ru.kursio.application.dao.RenatCouponDao;
import ru.kursio.application.dao.RenatQuizDao;
import ru.kursio.application.dao.RoleDao;
import ru.kursio.application.dao.UserDao;
import ru.kursio.application.model.entity.auth.Role;
import ru.kursio.application.model.entity.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kursio.application.model.entity.customization.renat.ColorQuizQuestion;
import ru.kursio.application.model.entity.customization.renat.Coupon;
import ru.kursio.application.service.RenatCouponService;
import ru.kursio.application.util.defaultFactory.CouponFactory;
import ru.kursio.application.util.defaultFactory.QuizFactory;

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
    RenatQuizDao renatQuizDao;

    @Autowired
    RenatCouponDao renatCouponDao;

    @Autowired
    RenatCouponService renatCouponService;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    @Transactional
    public void run(String... strings) {

        //>ROLES<///////////////////////////

        // SINGLE ROLE CASE
        Role role1 = new Role();
        role1.setRoleType("ADMIN_SUPPORT");
        Set<Role> hRoles = new HashSet<>();
        hRoles.add(role1);

        // SINGLE ROLE CASE
        Role role2 = new Role();
        Set<Role> hRoles2 = new HashSet<>();
        role2.setRoleType("STUDENT");
        hRoles2.add(role2);

        // DOUBLE ROLE CASE
        Role role3 = new Role();
        Set<Role> hRoles3 = new HashSet<>();
        role3.setRoleType("TEACHER");
        hRoles3.add(role3);
        hRoles3.add(role2);

        // Drop all Roles
        roleDao.deleteAll();

        // Add our Roles to Database
        List<Role> roles = Arrays.asList(role1, role2, role3);
        roleDao.saveAll(roles);

        // Users
        User user1 = new User();
        user1.setActive(true);
        user1.setName("Hubert");
        user1.setLastName("Alfaro");
        user1.setEmail("halfarob1@gmail.com");
        user1.setUserName("halfaro");
        user1.setPassword(encoder.encode("12345"));
        user1.setRoles(hRoles);

        User user2 = new User();
        user2.setActive(true);
        user2.setName("Andres");
        user2.setLastName("Artavia");
        user2.setEmail("artaviandres@gmail.com");
        user2.setUserName("aartavia");
        user2.setPassword(encoder.encode("12345"));
        user2.setRoles(hRoles2);

        User user3 = new User();
        user3.setActive(true);
        user3.setName("Renat");
        user3.setLastName("Kashapov");
        user3.setEmail("Renat.kashapov@hotmail.com");
        user3.setAvatar("http://promoboz.com/wp-content/uploads/2018/02/Bez-nazvaniya-2-4-529x720.png");
        user3.setUserName("rkashapov");
        user3.setPassword(encoder.encode("12345"));
        user3.setRoles(hRoles3);
        user3.setAboutMe("Renat Kashapov - certified trainer, expert on \"The Theory of Internal Motive Motive\" created by Dr. Taylor Hartman. He" +
                "has workded as professional coach for personal development");
        user3.setDesignation("Certified Trainer");
        user3.setIsTeacher(true);

        user3.setRatingAverage(5);
        user3.setFacebookUrl("https://www.facebook.com/cashupoff");
        user3.setLinkedInUrl("https://www.linkedin.com/in/cashupoff/");
        user3.setInstagramUrl("https://www.instagram.com/cashupoff/");
        User user4 = new User();
        user4.setActive(true);
        user4.setName("Jaime");
        user4.setLastName("Escobar");
        user4.setEmail("milloescobar@gmail.com");
        user4.setUserName("jescobar");
        user4.setPassword(encoder.encode("12345"));
        user4.setRoles(hRoles3);

        // Drop all Users
        userDao.deleteAll();

        // Add our Users to the Database
        List<User> users = Arrays.asList(user1, user2, user3, user4);
        List<User> savedUsers = userDao.saveAll(users);

        //RENAT QUIZ
        List<ColorQuizQuestion> questions = new QuizFactory().createQuiz("RENAT_COLOR_QUIZ");
        renatQuizDao.saveAll(questions);

        //RENAT COUPONS
        List<Coupon> coupons = new CouponFactory().createCoupons("RENAT_COUPON", savedUsers, renatCouponService);
        renatCouponDao.saveAll(coupons);

    }
}