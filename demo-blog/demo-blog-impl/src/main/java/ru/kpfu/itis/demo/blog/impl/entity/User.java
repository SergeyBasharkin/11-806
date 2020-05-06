package ru.kpfu.itis.demo.blog.impl.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;

@Data
@Table
@Entity
@EqualsAndHashCode(callSuper = true)
@ToString
public class User extends AutoincrementEntity implements UserDetails {

    private String username;
    private String password;
    private String email;
    private Boolean expired = Boolean.FALSE;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return expired;
    }
}
