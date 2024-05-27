package co.pickcake.auth.authdomain.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthAPI {

    @GetMapping("/")
    public String home() {
        return "test";
    }

    @GetMapping("/oauth2/login")
    public String get(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();

        return username;
    }

}
