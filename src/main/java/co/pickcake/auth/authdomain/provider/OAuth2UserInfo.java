package co.pickcake.auth.authdomain.provider;

import co.pickcake.auth.authdomain.entity.ProviderType;
import org.springframework.security.oauth2.core.AbstractOAuth2Token;

import java.util.Map;

public interface OAuth2UserInfo {

    Map<String, Object> getAttributes();

    AbstractOAuth2Token getAccessToken();

    String getId();

    String getName();

    String getEmail();

    String getProfiles();
}
