package mx.profuturo.ap.middle.service.auth;

import java.util.ArrayList;

import mx.profuturo.ap.middle.modelo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserAuthenticationService authenticationService;
 
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
        Usuario usuario =  authenticationService.authenticateToken((String) authentication.getCredentials());
      return new JwtAuthenticatedUserToken(usuario.getNumeroEmpleado(), new ArrayList<String>());
    }
 
    /*
     Returns true if this AuthenticationProvider supports the indicated Authentication object.
     */
    @Override
    public boolean supports(Class<?> aClass)
    {
        return JwtAuthToken.class.equals(aClass);
    }
}
