package mx.profuturo.ap.middle.service.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import mx.profuturo.ap.middle.modelo.global.SecurityConstants;
import mx.profuturo.ap.middle.service.exception.ServiceException;
import mx.profuturo.ap.middle.service.util.AuthUtilService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtService {
    private static final Logger LOGGER = Logger.getLogger(JwtService.class);

    @Autowired
    private AuthUtilService authUtilService;

    public String generateToken(String usuario) {
        Date expiration = new Date(System.currentTimeMillis() + SecurityConstants.ACCESS_TOKEN_VALIDITY_SECONDS * 1000);
        String token = "";
        //final String secretKey = authUtilService.encriptar(SecurityConstants.secretKey);

        try {
            token = Jwts.builder().setSubject(usuario).setExpiration(expiration).setIssuer(SecurityConstants.ISSUER)
                    .signWith(SignatureAlgorithm.HS512, SecurityConstants.secretKey).compact();
        } catch (Throwable throwable) {

            LOGGER.error(" [ JwtService ] Throwable : " + throwable.getMessage());
            LOGGER.error(" [ JwtService ] Throwable : ", throwable);
            throw new ServiceException(throwable.getMessage(), throwable);

        }
        return token;

    }

    public String verifyToken(String token) {

        //final String secretKey = authUtilService.encriptar(SecurityConstants.secretKey);
        Jws<Claims> claims = Jwts.parser().setSigningKey(SecurityConstants.secretKey).parseClaimsJws(token);
        String subject = "";
        // returning authenticated/verified username
        try {
            subject = claims.getBody().getSubject();

        } catch (Throwable throwable) {

            LOGGER.error(" [ JwtService ] Throwable : " + throwable.getMessage());
            LOGGER.error(" [ JwtService ] Throwable : ", throwable);
            throw new ServiceException(throwable.getMessage(), throwable);

        }

        return subject;
    }

}
