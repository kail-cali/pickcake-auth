package co.pickcake.auth.authdomain.exception;

import org.springframework.security.core.AuthenticationException;

public class NotImplementedRegistrationError extends AuthenticationException {

    public NotImplementedRegistrationError(String registrationId) {
        super("Not implemented registration of " + registrationId );
    }
}
