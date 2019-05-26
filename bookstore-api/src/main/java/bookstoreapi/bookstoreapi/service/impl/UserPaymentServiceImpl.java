package bookstoreapi.bookstoreapi.service.impl;

import bookstoreapi.bookstoreapi.model.UserPayment;
import bookstoreapi.bookstoreapi.repository.UserPaymentRepository;
import bookstoreapi.bookstoreapi.service.UserPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by @kmartin62
 */
@Service
public class UserPaymentServiceImpl implements UserPaymentService {

    @Autowired
    private UserPaymentRepository userPaymentRepository;

    @Override
    public Optional<UserPayment> findById(Long id) {
        return userPaymentRepository.findById(id);
    }

    @Override
    public void removeById(Long id) {
        userPaymentRepository.deleteById(id);
    }
}
