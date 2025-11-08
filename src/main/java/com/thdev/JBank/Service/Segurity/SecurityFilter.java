package com.thdev.JBank.Service.Segurity;

import com.thdev.JBank.Infrastructure.UserRepository;
import com.thdev.JBank.Service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private UserRepository ur;
    @Autowired
    private TokenService ts;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = recoverToken(request);
        if(token != null){
            var subject = ts.validadeToken(token);
            UserDetails userDetails = (UserDetails)ur.findByCpf(subject);

            var authentication = new UsernamePasswordAuthenticationToken(userDetails,null,
                    userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        var authorization = request.getHeader("Authorization");
        if (authorization == null) { return null;}
        return authorization.replace("Bearer ", "");
    }
}

