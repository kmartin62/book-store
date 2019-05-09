package bookstoreapi.bookstoreapi.domain;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * Created by @kmartin62
 */
public class Authority implements GrantedAuthority, Serializable {
    @Override
    public String getAuthority() {
        return null;
    }
}
