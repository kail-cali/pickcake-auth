package co.pickcake.auth.authdomain.service;

import co.pickcake.auth.authdomain.entity.ProviderType;
import co.pickcake.auth.authdomain.exception.NotImplementedRegistrationError;
import co.pickcake.auth.authdomain.provider.GoogleOAuth2UserInfo;
import co.pickcake.auth.authdomain.provider.OAuth2UserInfo;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class SocialAuthService implements OAuth2UserInfoFactory {



    @Override
    public OAuth2User build(OAuth2UserRequest userRequest, OAuth2User user) {
        OAuth2UserInfo userInfo = null;
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        /* */
        if (registrationId.equals(ProviderType.GOOGLE.toString().toLowerCase())) {
            userInfo = GoogleOAuth2UserInfo.builder()
                    .email(user.getAttribute("email"))
                    .accessToken(userRequest.getAccessToken())
                    .attributes(user.getAttributes())
                    .build();
        }

        if (userInfo == null) {
            throw new NotImplementedRegistrationError(registrationId);
        }

        return new OAuth2UserPrincipal(userInfo);

    }
}
