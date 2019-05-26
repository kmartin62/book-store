package bookstoreapi.bookstoreapi.service.impl;

import bookstoreapi.bookstoreapi.model.UserShipping;
import bookstoreapi.bookstoreapi.repository.UserShippingRepository;
import bookstoreapi.bookstoreapi.service.UserShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by @kmartin62
 */
@Service
public class UserShippingServiceImpl implements UserShippingService {

    @Autowired
    private UserShippingRepository userShippingRepository;

    @Override
    public Optional<UserShipping> findById(Long id) {
        return userShippingRepository.findById(id);
    }

    @Override
    public void removeById(Long id) {
        userShippingRepository.deleteById(id);
    }
}
