package bookstoreapi.bookstoreapi.model.security;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * Created by @kmartin62
 */
public class Authority implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 3562825123123680034L;

    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
