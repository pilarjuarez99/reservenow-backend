package com.reservenow.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    private static final List<String> PUBLIC_PATHS = List.of(
        "/api/auth",
        "/api/products",
        "/api/calificaciones",
        "/h2-console"
    );

    private boolean isPublicPath(HttpServletRequest request) {
        String path = request.getRequestURI();
        return PUBLIC_PATHS.stream().anyMatch(path::startsWith);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {

        if (isPublicPath(req)) {
            chain.doFilter(req, res);
            return;
        }

        String authHeader = req.getHeader("Authorization");
        String token = null;
        String email = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            try {
                email = jwtUtil.extractEmail(token);
            } catch (Exception e) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        } else {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            var userDetail = userDetailsService.loadUserByUsername(email);
            if (jwtUtil.validateToken(token)) {
                var authToken = new UsernamePasswordAuthenticationToken(
                    userDetail,
                    null,
                    userDetail.getAuthorities() // Asegúrate de devolver al menos ROLE_USER
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        chain.doFilter(req, res);
    }
}