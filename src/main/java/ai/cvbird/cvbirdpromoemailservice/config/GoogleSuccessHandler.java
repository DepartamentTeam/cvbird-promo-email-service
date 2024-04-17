package ai.cvbird.cvbirdpromoemailservice.config;

import ai.cvbird.cvbirdpromoemailservice.dto.GoogleUserDTO;
import ai.cvbird.cvbirdpromoemailservice.service.UserEmailStoreService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GoogleSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    UserEmailStoreService userEmailStoreService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (authentication.getPrincipal() instanceof DefaultOAuth2User) {
            GoogleUserDTO googleUserDTO = new GoogleUserDTO();
            googleUserDTO.setGoogleEmail(((DefaultOAuth2User) authentication.getPrincipal()).getAttribute("email"));
            googleUserDTO.setGoogleName(((DefaultOAuth2User) authentication.getPrincipal()).getAttribute("name"));
            googleUserDTO.setGoogleUserAttributes(((DefaultOAuth2User) authentication.getPrincipal()).getAttributes().toString());
            userEmailStoreService.saveGoogleUser(googleUserDTO);
            handle(request, response, authentication);
        }
    }
    protected void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException {

        String targetUrl = "https://cvbird.ai";

        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
}
