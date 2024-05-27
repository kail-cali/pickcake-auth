package co.pickcake.auth.authdomain.provider;

import co.pickcake.auth.authdomain.entity.ProviderType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Map;

public class GoogleOAuth2UserInfo implements OAuth2UserInfo {

    private final String email;
    private final String accessToken;
    private final String name;
    private final String profileImageUrl;
    private final String id;

    @Enumerated(EnumType.STRING)
    private final ProviderType providerType;


    public GoogleOAuth2UserInfo(String email, String accessToken, String name, String profileImageUrl, String id, ProviderType providerType) {
        this.email = email;
        this.accessToken = accessToken;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.id = id;
        this.providerType = providerType;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return Map.of();
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getProfiles() {
        return profileImageUrl;
    }
}
