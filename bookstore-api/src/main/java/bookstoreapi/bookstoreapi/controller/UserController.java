package bookstoreapi.bookstoreapi.controller;

import bookstoreapi.bookstoreapi.config.SecurityUtility;
import bookstoreapi.bookstoreapi.model.User;
import bookstoreapi.bookstoreapi.model.security.Role;
import bookstoreapi.bookstoreapi.model.security.UserRole;
import bookstoreapi.bookstoreapi.service.UserService;
import bookstoreapi.bookstoreapi.utility.MailConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by @kmartin62
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;
//
//    @Autowired
//    public UserController(MailConstructor mailConstructor, JavaMailSender mailSender) {
////        this.userService = userService;
//    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public ResponseEntity newUser(HttpServletRequest request, @RequestBody HashMap<String, String> map) throws Exception{
        String username = map.get("username");
        String password = map.get("password");

        String email = map.get("email");
        if(userService.findByUsername(username) != null) {
            return new ResponseEntity("Exsists", HttpStatus.BAD_REQUEST);
        }

        if(userService.findByEmail(email) != null) {
            return new ResponseEntity("Exsists", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
//        user.setPassword("p");
        user.setUsername(username);
        user.setEmail(email);

//        String password = SecurityUtility.randomPassword();
//
//        String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
        user.setPassword(SecurityUtility.passwordEncoder().encode(password));


        Role role = new Role();
        role.setRoleId(2); //normal user
        role.setName("ROLE_USER");

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, role));
        userService.createUser(user, userRoles);


        return new ResponseEntity("Done", HttpStatus.OK);


    }
}
