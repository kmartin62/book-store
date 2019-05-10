package bookstoreapi.bookstoreapi.service;

import bookstoreapi.bookstoreapi.domain.User;
import bookstoreapi.bookstoreapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by @kmartin62
 */
@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String u = username;
        User user = userRepository.findByUsername(u);

        if(user == null){
            throw new UsernameNotFoundException("Username not found");
        }

        return user;
    }
}
