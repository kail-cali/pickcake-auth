package co.pickcake.auth.authdomain.service;

import co.pickcake.auth.authdomain.entity.ProviderType;
import co.pickcake.auth.authdomain.exception.NotImplementedRegistrationError;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;


@Component
public class SocialAuthService implements OAuth2UserInfoFactory {

    @Override
    public OAuth2User build(OAuth2UserRequest userRequest, OAuth2User user) {
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        System.out.println("registrationId = " + registrationId);

        if (registrationId.equals(ProviderType.GOOGLE.toString())) {
            
        }

        throw new NotImplementedRegistrationError(registrationId);
    }
}
