package bookstoreapi.bookstoreapi.service;

import bookstoreapi.bookstoreapi.domain.User;
import bookstoreapi.bookstoreapi.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by @kmartin62
 */
@Service
public class UserSecurityService implements UserDetailsService {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserSecurityService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null){
            LOGGER.warning("Username not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return user;
    }
}
