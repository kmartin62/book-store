package bookstoreapi.bookstoreapi.model.security;

import bookstoreapi.bookstoreapi.model.User;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by @kmartin62
 */
@Entity
@Table(name="user_role")
public class UserRole implements Serializable {
    private static final long serialUID = 123123L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    public UserRole(){}

    public UserRole(User user, Role role){
        this.user = user;
        this.role = role;
    }

    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
