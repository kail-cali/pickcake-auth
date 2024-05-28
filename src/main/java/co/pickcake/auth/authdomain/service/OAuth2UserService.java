package co.pickcake.auth.authdomain.service;

import co.pickcake.auth.authdomain.entity.Member;
import co.pickcake.auth.authdomain.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OAuth2UserService extends DefaultOAuth2UserService {

    /* 현 버전에서는 SocialAuthService 호출 */
    private final OAuth2UserInfoFactory oAuth2UserInfoFactory;
    private final MemberJpaRepository memberJpaRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        OAuth2User member = oAuth2UserInfoFactory.build(userRequest, oAuth2User);
        save(member);
        return member;
    }

    private void save(OAuth2User oAuth2User) {
        Optional<Member> member = memberJpaRepository.findByEmail(oAuth2User.getAttribute("email"));
        member.ifPresent(memberJpaRepository::save);
    }



}
