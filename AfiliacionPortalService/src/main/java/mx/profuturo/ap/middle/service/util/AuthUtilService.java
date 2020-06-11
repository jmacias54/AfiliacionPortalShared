
package mx.profuturo.ap.middle.service.util;

import java.io.UnsupportedEncodingException;

import mx.profuturo.ap.middle.service.exception.ServiceException;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class AuthUtilService {
    private static final Logger LOGGER = Logger.getLogger(AuthUtilService.class);

    
    public String encriptar(String valorEncriptar ){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String out = "";
                
        try{
            out=  encoder.encode(valorEncriptar);

        }catch(Throwable throwable){
            
            LOGGER.error(" [ JwtService ] Throwable : "+throwable.getMessage());
            LOGGER.error(" [ JwtService ] Throwable : ",throwable);
            throw new ServiceException(throwable.getMessage(), throwable);

            
        }
        return out;
    }
    
    public static boolean desencriptar(String encodeVal , String matchVal ) throws UnsupportedEncodingException{
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        boolean isPasswordMatch = encoder.matches(matchVal, encodeVal);

        return isPasswordMatch;
    }
}
