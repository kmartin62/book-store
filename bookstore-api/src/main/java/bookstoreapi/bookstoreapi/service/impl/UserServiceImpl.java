package bookstoreapi.bookstoreapi.service.impl;

import bookstoreapi.bookstoreapi.domain.User;
import bookstoreapi.bookstoreapi.domain.security.UserRole;
import bookstoreapi.bookstoreapi.repository.RoleRepository;
import bookstoreapi.bookstoreapi.repository.UserRepository;
import bookstoreapi.bookstoreapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by @kmartin62
 */
@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User user1 = userRepository.findByUsername(user.getUsername());

        if(user1 != null){
            System.out.println("FVCK");
            throw new Exception();
        }
//        else {
//            for (UserRole ur : userRoles){
//                roleRepository.save(ur.getRole());
//            }
//
//            user.getUserRoles().addAll(userRoles);
//            user1 = userRepository.save(user);
//        }

        return user1;
    }
}
