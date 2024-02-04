package com.app.ReviewHub.Model.Enum;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@AllArgsConstructor
public enum Role {
    Admin(Permitions.all),
    User(Permitions.all),
    Moderator(Permitions.all);

    private final Permitions role;

    public List<GrantedAuthority> getRoles() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }
}
