package mx.profuturo.ap.middle.web.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import mx.profuturo.ap.middle.modelo.global.SecurityConstants;
import mx.profuturo.ap.middle.service.auth.JwtAuthToken;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
public class JwtAuthFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String authorization = servletRequest.getHeader(SecurityConstants.HEADER_AUTHORIZACION_KEY);
 
        if (authorization != null)
        {
            JwtAuthToken token = new JwtAuthToken(authorization.replaceAll(SecurityConstants.TOKEN_PREFIX, ""));
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        filterChain.doFilter(servletRequest, response);
        
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

}
