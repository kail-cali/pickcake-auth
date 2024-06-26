package co.pickcake.auth.authdomain.handler;


import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
}
