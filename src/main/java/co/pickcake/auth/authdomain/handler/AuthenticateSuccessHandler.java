package co.pickcake.auth.authdomain.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticateSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
}
