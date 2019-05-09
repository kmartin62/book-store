package bookstoreapi.bookstoreapi.domain.security;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * Created by @kmartin62
 */
public class Authority implements GrantedAuthority, Serializable {

    private static final long serialUID = 555666L;

    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
