package bookstoreapi.bookstoreapi;

import bookstoreapi.bookstoreapi.config.SecurityUtility;
import bookstoreapi.bookstoreapi.model.User;
import bookstoreapi.bookstoreapi.model.security.Role;
import bookstoreapi.bookstoreapi.model.security.UserRole;
import bookstoreapi.bookstoreapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@Transactional
public class BookstoreApiApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApiApplication.class, args);
    }

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setFirstName("Test");
        user.setLastName("User");
        user.setUsername("admin");
        user.setPassword(SecurityUtility.passwordEncoder().encode("p"));
        user.setEmail("testuser@gmail.com");
        Set<UserRole> userRoles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(1);
        role.setName("ROLE_ADMIN");
        userRoles.add(new UserRole(user, role));

        userService.createUser(user, userRoles);

        userRoles.clear();

        User user1= new User();
        user1.setFirstName("Zivko");
        user1.setLastName("Jovanov");
        user1.setUsername("zika");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
        user1.setEmail("zika193@gmail.com");
        Role role1 = new Role();
        role1.setRoleId(2);
        role1.setName("ROLE_USER");
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1, userRoles);

        userRoles.clear();
    }
}
