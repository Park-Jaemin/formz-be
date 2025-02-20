package ForMZ.Server.domain.user;

import ForMZ.Server.domain.jwt.JwtService;
import ForMZ.Server.domain.jwt.JwtTokenRes;
import ForMZ.Server.domain.user.entity.User;
import ForMZ.Server.domain.user.repository.UserRepository;
import ForMZ.Server.domain.user.service.UserServiceImpl;
import ForMZ.Server.global.oauth.OAuthRequestUtil;
import ForMZ.Server.global.oauth.dto.OAuthUserInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    OAuthRequestUtil oAuthRequestUtil;

    @Mock
    JwtService jwtService;

    @Test
    @DisplayName("OAuth 첫 로그인, Access Token 발급")
    void loginOAuth_issueAccessToken() {
        // given
        String accessToken = "엑세스 토큰";
        String refreshToken = "리프레시 토큰";
        User user = User.builder().id(1L).build();
        OAuthUserInfo oAuthUserInfo = OAuthUserInfo.builder().build();

        doReturn(oAuthUserInfo).when(oAuthRequestUtil).getOAuthUserInfo(anyString(), anyString());
        doReturn(Optional.empty()).when(userRepository).findBySignTypeAndSocialId(oAuthUserInfo.getSocialType(), oAuthUserInfo.getSocialId());
        doReturn(user).when(userRepository).save(any());
        doReturn(new JwtTokenRes(accessToken, refreshToken)).when(jwtService).createJwtToken(user.getId());

        // when
        JwtTokenRes jwtTokenRes = userService.loginOAuth(anyString(), anyString());

        // then
        assertThat(jwtTokenRes.accessToken()).isEqualTo(accessToken);
        assertThat(jwtTokenRes.refreshToken()).isEqualTo(refreshToken);
    }

    @Test
    @DisplayName("OAuth 로그인, User 정보 변경, Access Token 발급")
    void loginOAuthUpdateEmail_issueAccessToken() {
        // given
        String accessToken = "엑세스 토큰";
        String refreshToken = "리프레시 토큰";
        String updateEmail = "변경 이메일";
        User user = User.builder().id(1L).email("기존 이메일").build();
        OAuthUserInfo oAuthUserInfo = OAuthUserInfo.builder().email(updateEmail).build();

        doReturn(oAuthUserInfo).when(oAuthRequestUtil).getOAuthUserInfo(anyString(), anyString());
        doReturn(Optional.of(user)).when(userRepository).findBySignTypeAndSocialId(oAuthUserInfo.getSocialType(), oAuthUserInfo.getSocialId());
        doReturn(new JwtTokenRes(accessToken, refreshToken)).when(jwtService).createJwtToken(user.getId());

        // when
        JwtTokenRes jwtTokenRes = userService.loginOAuth(anyString(), anyString());

        // then
        assertThat(user.getEmail()).isEqualTo(updateEmail);
        assertThat(jwtTokenRes.accessToken()).isEqualTo(accessToken);
        assertThat(jwtTokenRes.refreshToken()).isEqualTo(refreshToken);
    }
}
