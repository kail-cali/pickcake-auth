package co.pickcake.auth.authdomain.provider;

import co.pickcake.auth.authdomain.entity.ProviderType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import org.springframework.security.oauth2.core.AbstractOAuth2Token;

import java.util.Map;

public class GoogleOAuth2UserInfo implements OAuth2UserInfo {

    private final String email;
    private final AbstractOAuth2Token accessToken;
    private final Map<String, Object> attributes;

    @Enumerated(EnumType.STRING)
    private final ProviderType providerType;

    @Builder
    public GoogleOAuth2UserInfo(String email, AbstractOAuth2Token accessToken, String name, String profileImageUrl, String id, Map<String, Object> attributes, ProviderType providerType) {
        this.email = email;
        this.accessToken = accessToken;
        this.attributes = attributes;
        this.providerType = providerType;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return Map.of();
    }

    @Override
    public AbstractOAuth2Token getAccessToken() {
        return accessToken;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getProfiles() {
        return null;
    }
}
