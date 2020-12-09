package pl.coderslab.charity.entity.user_security;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
public class CurrentUser extends User {
    private final pl.coderslab.charity.entity.user_security.User appUser;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.coderslab.charity.entity.user_security.User appUser) {
        super(username, password, authorities);
        this.appUser = appUser;
    }

    public pl.coderslab.charity.entity.user_security.User getAppUser() {
        return appUser;
    }
}
