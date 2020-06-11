package mx.profuturo.ap.middle.modelo.global;

public final class SecurityConstants {
    
 // Spring Security

    public static final String LOGIN_URL = "/login";
    public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60;

    public static final String SIGNING_KEY = "devglan123r";
    public static final String ISSUER = "portal-afiliacion-mit-profuturo";
    
    //public static final String secretKey = "secretKey";
    public static final String secretKey ="$2a$10$Od./TFNbMzEtaO7B8V30LOhX3llBc7hh8/ve1vqcoAkCYbIhrNssK";
    // JWT

    public static final String ISSUER_INFO = "https://www.autentia.com/";
    public static final String SUPER_SECRET_KEY = "1234";
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

}
