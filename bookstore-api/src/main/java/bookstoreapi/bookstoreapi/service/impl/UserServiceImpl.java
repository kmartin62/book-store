package bookstoreapi.bookstoreapi.service.impl;

import java.util.Set;

import bookstoreapi.bookstoreapi.domain.User;
import bookstoreapi.bookstoreapi.domain.security.UserRole;
import bookstoreapi.bookstoreapi.repository.RoleRepository;
import bookstoreapi.bookstoreapi.repository.UserRepository;
import bookstoreapi.bookstoreapi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(User user, Set<UserRole> userRoles) {
        User user1 = userRepository.findByUsername(user.getUsername());

        if(user1 != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        } else {
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);

            user1 = userRepository.save(user);
        }

        return user1;
    }
}
