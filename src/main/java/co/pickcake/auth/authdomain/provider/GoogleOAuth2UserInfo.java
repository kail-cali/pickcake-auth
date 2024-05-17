package co.pickcake.auth.authdomain.provider;

import co.pickcake.auth.authdomain.entity.ProviderType;

import java.util.Map;

public class GoogleOAuth2UserInfo implements OAuth2UserInfo {

    private final String email;

    public GoogleOAuth2UserInfo(String email) {
        this.email = email;
    }

    @Override
    public ProviderType getProvider() {
        return ProviderType.GOOGLE;
    }

    @Override
    public String getAccessToken() {
        return "";
    }

    @Override
    public String getId() {
        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getProfiles() {
        return "";
    }
}
