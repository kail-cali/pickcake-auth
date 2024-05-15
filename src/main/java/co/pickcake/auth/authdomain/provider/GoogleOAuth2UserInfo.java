package co.pickcake.auth.authdomain.provider;

import co.pickcake.auth.authdomain.entity.ProviderType;

import java.util.Map;

public class GoogleOAuth2UserInfo implements OAuth2UserInfo {
    @Override
    public ProviderType getProvider() {
        return ProviderType.GOOGLE;
    }

    @Override
    public String getAccessToken() {
        return "";
    }

    @Override
    public Map<String, Object> getAttributes() {
        return Map.of();
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
        return "";
    }

    @Override
    public String getProfiles() {
        return "";
    }
}
