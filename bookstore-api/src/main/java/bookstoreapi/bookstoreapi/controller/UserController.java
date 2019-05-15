package bookstoreapi.bookstoreapi.controller;

import bookstoreapi.bookstoreapi.config.SecurityConfig;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by @kmartin62
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

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
        user.setUsername(username);
        user.setEmail(email);

        user.setPassword(SecurityUtility.passwordEncoder().encode(password));


        Role role = new Role();
        role.setRoleId(2); //normal user
        role.setName("ROLE_USER");

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, role));
        userService.createUser(user, userRoles);


        return new ResponseEntity("Done", HttpStatus.OK);
    }

    @RequestMapping(value="/updateUserInfo", method=RequestMethod.POST)
    public ResponseEntity profileInfo(
            @RequestBody HashMap<String, Object> mapper
    ) throws Exception{

        int id = (Integer) mapper.get("id");
        String email = (String) mapper.get("email");
        String username = (String) mapper.get("username");
        String firstName = (String) mapper.get("firstName");
        String lastName = (String) mapper.get("lastName");
        String newPassword = (String) mapper.get("newPassword");
        String currentPassword = (String) mapper.get("currentPassword");

        Optional<User> currentUser = userService.findById(Long.valueOf(id));

        if(currentUser == null) {
            throw new Exception ("User not found");
        }

        if(userService.findByEmail(email) != null) {
            if(userService.findByEmail(email).getId() != currentUser.get().getId()) {
                return new ResponseEntity("Email not found!", HttpStatus.BAD_REQUEST);
            }
        }

        if(userService.findByUsername(username) != null) {
            if(userService.findByUsername(username).getId() != currentUser.get().getId()) {
                return new ResponseEntity("Username not found!", HttpStatus.BAD_REQUEST);
            }
        }

        SecurityConfig securityConfig = new SecurityConfig();

        if(newPassword != null && !newPassword.isEmpty() && !newPassword.equals("")) {
            BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
            String dbPassword = currentUser.get().getPassword();
            if(currentPassword.equals(dbPassword)) {
                currentUser.get().setPassword(passwordEncoder.encode(newPassword));
            } else {
                return new ResponseEntity("Incorrect current password!", HttpStatus.BAD_REQUEST);
            }
        }

        currentUser.get().setFirstName(firstName);
        currentUser.get().setLastName(lastName);
        currentUser.get().setUsername(username);
        currentUser.get().setEmail(email);

        userService.save(currentUser.get());

        return new ResponseEntity("Update Success", HttpStatus.OK);
    }

    @RequestMapping("/getCurrentUser")
    public User getCurrentUser(Principal principal) {
        User user = new User();
        if (null != principal) {
            user = userService.findByUsername(principal.getName());
        }

        return user;
    }
}
