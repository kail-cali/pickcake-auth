package co.pickcake.auth.authdomain.provider;

import co.pickcake.auth.authdomain.entity.ProviderType;

import java.util.Map;

public interface OAuth2UserInfo {

    ProviderType getProvider();

    String getAccessToken();

    Map<String ,Object> getAttributes();

    String getId();

    String getName();

    String getEmail();

    String getProfiles();
}
