package co.pickcake.auth.authdomain.service;

import co.pickcake.auth.authdomain.provider.OAuth2UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.nio.file.attribute.UserPrincipal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OAuth2UserPrincipal implements OAuth2User, UserPrincipal {

    private final OAuth2UserInfo userInfo;

    public OAuth2UserPrincipal(OAuth2UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return userInfo.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();

    }

    @Override
    public String getName() {
        return userInfo.getEmail();
    }

    public String getUserName() {
        return userInfo.getEmail();
    }


    public OAuth2UserInfo getUserInfo() {
        return userInfo;
    }
}
