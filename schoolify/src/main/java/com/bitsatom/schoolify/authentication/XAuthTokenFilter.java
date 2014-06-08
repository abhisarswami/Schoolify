package com.bitsatom.schoolify.authentication;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

@Component
@Order(1)
public class XAuthTokenFilter extends GenericFilterBean {

    private final UserDetailsService detailsService;
    private final TokenUtils tokenUtils = new TokenUtils();
    private String xAuthTokenHeaderName = "x-auth-token";

    @Autowired
    public XAuthTokenFilter(UserDetailsService userDetailsService) {
        this.detailsService = userDetailsService;
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) arg0;
            String authToken = httpServletRequest.getHeader(this.xAuthTokenHeaderName);

            if (StringUtils.hasText(authToken)) {
                String username = this.tokenUtils.getUserNameFromToken(authToken);

                UserDetails details = this.detailsService.loadUserByUsername(username);

                if (this.tokenUtils.validateToken(authToken, details)) {
                    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(details, details.getPassword(), details.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(token);
                }
            }
            filterChain.doFilter(arg0, arg1);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}