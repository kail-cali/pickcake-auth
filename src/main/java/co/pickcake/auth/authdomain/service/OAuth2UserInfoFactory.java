package co.pickcake.auth.authdomain.service;


import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;


public interface OAuth2UserInfoFactory {

    /* Factory 패턴으로 설계하다 보니 서비스계층에서 호출하는 필수 메서드명 형상 관리가 필요하여
    *  interface & 구현 방식으로 변경 */
    OAuth2User build(OAuth2UserRequest userRequest, OAuth2User user);

}
