package com.FTIsland.BE.oauth2.service;


import com.FTIsland.BE.entity.SocialType;
import com.FTIsland.BE.entity.User;
import com.FTIsland.BE.oauth2.CustomOAuth2User;
import com.FTIsland.BE.oauth2.OAuthAttributes;
import com.FTIsland.BE.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;

    private static final String NAVER = "naver";
    private static final String KAKAO = "kakao";

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("CustomOAuth2UserService.loadUser() 실행 - OAuth2 로그인 요청 진입");

        /**
         * DefaultOAuth2UserService 객체를 생성하여, loadUser(userRequest)를 통해 DefaultOAuth2User 객체를 생성 후 반환
         * DefaultOAuth2UserService의 loadUser()는 소셜 로그인 API의 사용자 정보 제공 URI로 요청을 보내서
         * 사용자 정보를 얻은 후, 이를 통해 DefaultOAuth2User 객체를 생성 후 반환한다.
         * 결과적으로, OAuth2User는 OAuth 서비스에서 가져온 유저 정보를 담고 있는 유저
         */
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        /**
         * userRequest에서 registrationId 추출 후 registrationId으로 SocialType 저장
         * http://localhost:8080/oauth2/authorization/kakao에서 kakao가 registrationId
         * userNameAttributeName은 이후에 nameAttributeKey로 설정된다.
         */
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        SocialType socialType = getSocialType(registrationId);

        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName(); // OAuth2 로그인 시 키(PK)가 되는 값

        Map<String, Object> attributes = oAuth2User.getAttributes(); // 소셜 로그인에서 API가 제공하는 userInfo의 Json 값(유저 정보들)

        // socialType에 따라 유저 정보를 통해 OAuthAttributes 객체 생성
        OAuthAttributes extractAttributes = OAuthAttributes.of(socialType, userNameAttributeName, attributes);

        List<User> createdUsers = getUser(extractAttributes, socialType);

        CustomOAuth2User customOAuth2UserKid = new CustomOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(createdUsers.get(0).getRole().getKey())),
                attributes,
                extractAttributes.getNameAttributeKey(),
                createdUsers.get(0).getEmail(),
                createdUsers.get(0).getRole()
        );
//        CustomOAuth2User customOAuth2UserParent = new CustomOAuth2User(
//                Collections.singleton(new SimpleGrantedAuthority(createdUsers.get(1).getRole().getKey())),
//                extractAttributesParent,
//                extractAttributesParent.getNameAttributeKey(),
//                createdUsers.get(1).getEmail(),
//                createdUsers.get(1).getRole()
//        );
//
//        List<OAuth2User> customOAuth2Users = new ArrayList<>();
//        customOAuth2Users.add(customOAuth2UserKid);
//        customOAuth2Users.add(customOAuth2UserParent);

        return customOAuth2UserKid; // 하나 정보만 return해도 부모는 id만 다름
    }

    private SocialType getSocialType(String registrationId) {
        return SocialType.GOOGLE;
    }

    /**
     * SocialType과 attributes에 들어있는 소셜 로그인의 식별값 id를 통해 회원을 찾아 반환하는 메소드
     * 만약 찾은 회원이 있다면, 그대로 반환하고 없다면 saveUser()를 호출하여 회원을 저장한다.
     */
    private List<User> getUser(OAuthAttributes attributes, SocialType socialType) {
//        User findUser = userRepository.findBySocialTypeAndSocialId(socialType,
//                attributes.getOauth2UserInfo().getId()).orElse(null);

        User findUserKid = userRepository.findByEmailWithisParent(attributes.getOauth2UserInfo().getEmail() + "0").orElse(null); // email0이 없으면 null
        User findUserParent = userRepository.findByEmailWithisParent(attributes.getOauth2UserInfo().getEmail() + "1").orElse(null);

        if(findUserKid == null) {
            return saveUsers(attributes, socialType);
        }

        List<User> findUsers = new ArrayList<>();

        findUsers.add(findUserKid);
        findUsers.add(findUserParent);

        return findUsers;
    }

    /**
     * OAuthAttributes의 toEntity() 메소드를 통해 빌더로 User 객체 생성 후 반환
     * 생성된 User 객체를 DB에 저장 : socialType, socialId, email, role 값만 있는 상태
     */
//    private User saveUser(OAuthAttributes attributes, SocialType socialType) {
//        User createdUser = attributes.toEntity(socialType, attributes.getOauth2UserInfo());
//
//        return userRepository.save(createdUser);
//    }
    private List<User> saveUsers(OAuthAttributes attributes, SocialType socialType) {


        User createdUserKid = attributes.toEntityKid(socialType, attributes.getOauth2UserInfo());
        User createdUserParent = attributes.toEntityParent(socialType, attributes.getOauth2UserInfo());

        List<User> createdUsers = new ArrayList<>();

        createdUsers.add(userRepository.save(createdUserKid));
        createdUsers.add(userRepository.save(createdUserParent));

        return createdUsers;
    }

}
