package com.oauth2.sso.filter;

import com.oauth2.sso.service.JWTTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class UserDetailsValidationFilter extends OncePerRequestFilter {
    @Autowired
    private JWTTokenService jwtTokenService;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorisation = request.getHeader("Authorization");
        if(authorisation !=null) {
            if (authorisation.contains("Bearer")){
                String token = authorisation.substring(7);
                System.out.println("token---->" + token);
                String tokenUserName = jwtTokenService.getUserNameFromToken(token);
                System.out.println("tokenUserName---->" + tokenUserName);
                UserDetails userDetails = userDetailsService.loadUserByUsername(tokenUserName);
                if(jwtTokenService.isValidToken(token, userDetails)) {
                    System.out.println("Token is valid");
                    UsernamePasswordAuthenticationToken authenticator =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticator.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticator);
                }

            }
        }
        filterChain.doFilter(request,response);
    }
}
