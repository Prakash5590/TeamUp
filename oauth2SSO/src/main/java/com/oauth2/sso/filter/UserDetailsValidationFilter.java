package com.oauth2.sso.filter;

import com.oauth2.sso.service.JWTTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
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
                String token = authorisation.substring(6);
                System.out.println("token---->" + token);
                String tokenUserName = jwtTokenService.getUserNameFromToken(token);
                System.out.println("tokenUserName---->" + tokenUserName);
                if(jwtTokenService.isValidToken(token, userDetailsService.loadUserByUsername(tokenUserName))) {
                    System.out.println("Token is valid");
            }

            }
        }
        filterChain.doFilter(request,response);
    }
}
