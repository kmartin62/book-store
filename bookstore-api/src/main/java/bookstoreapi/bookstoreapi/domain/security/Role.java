package bookstoreapi.bookstoreapi.domain.security;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by @kmartin62
 */

@Entity
public class Role implements Serializable {

    private static final long serialUID = 556655L;

    @Id
    private int roleId;

    private String name;

    private Set<UserRole> userRoleSet = new HashSet<>();

    public Role(){}

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
}
