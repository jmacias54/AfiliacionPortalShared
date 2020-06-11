package mx.profuturo.ap.middle.service.helper;

import mx.profuturo.ap.middle.modelo.AutenticacionUsuario;
import mx.profuturo.ap.middle.modelo.ConsultaInformacionUsuario;
import mx.profuturo.ap.middle.modelo.Usuario;
import mx.profuturo.ap.middle.modelo.global.AuthMethodsConstants;
import mx.profuturo.ap.middle.modelo.global.Constantes;
import mx.profuturo.ap.middle.modelo.global.SecurityConstants;
import mx.profuturo.ap.middle.modelo.global.UserAuthenticationException;
import mx.profuturo.ap.middle.modelo.in.AutenticacionUsuarioIn;
import mx.profuturo.ap.middle.modelo.in.ConsultaInformacionUsuarioIn;
import mx.profuturo.ap.middle.modelo.out.AutenticacionUsuarioOut;
import mx.profuturo.ap.middle.modelo.out.ConsultaInformacionUsuarioOut;
import mx.profuturo.ap.middle.service.exception.ServiceException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@PropertySource(value = { "classpath:application.properties" })
public class AutenticacionRestCalling {
    private static final Logger LOGGER = Logger.getLogger(AutenticacionRestCalling.class);

    @Value("${url.autenticacion}")
    private String autenticacionURL;

    @Value("${token.autenticacion}")
    private String token;
    


    public Usuario consultaInformacionUsuario(ConsultaInformacionUsuario in) {
        LOGGER.info(" --- consultaInformacionUsuario --- ");
        LOGGER.info(" ConsultaInformacionUsuario:" + in);

        
        
        ObjectMapper objectMapper = new ObjectMapper();
        Usuario usuario = null;
        String response = "";

        try {

             response = postRequest(AuthMethodsConstants.METHOD_CONSULTA_INFORMACION_USUARIO, ConsultaInformacionUsuarioIn.builder().rqt(in).build());

            if (response != null && !response.equals("")) {
                ConsultaInformacionUsuarioOut out = objectMapper.readValue(response, ConsultaInformacionUsuarioOut.class);
                usuario = out.getEmpleado();
            }

            else
                throw new ServiceException("Error al consultar la informacion del usuario :" + in.getUsuario());

        }  catch (Throwable e) {
            LOGGER.error("Error en autenticacionUsuario " + e.getMessage());
            LOGGER.error("Error en autenticacionUsuario  ", e);

            try {
                UserAuthenticationException exception = objectMapper.readValue(response, UserAuthenticationException.class);
                LOGGER.info(" UserAuthenticationException:" + exception);

                throw new ServiceException(exception.getException(), e);

            } catch (Throwable throwable) {
                throw new ServiceException(throwable.getMessage(), throwable);
            }

        }
        return usuario;

    }

    public AutenticacionUsuarioOut autenticacionUsuario(AutenticacionUsuario in) {
        LOGGER.info(" --- autenticacionUsuario --- ");

        String response = "";

        ObjectMapper objectMapper = new ObjectMapper();
        AutenticacionUsuarioOut out = null;
        try {
        
            response =  postRequest(AuthMethodsConstants.METHOD_AUTH_USUARIO, AutenticacionUsuarioIn.builder().rqt(in).build());
            if (response != null && !response.equals(""))
                out = objectMapper.readValue(response, AutenticacionUsuarioOut.class);
            else
                throw new ServiceException("Error al autenticar el usuario :" + in.getUsuario());

        } catch (Throwable e) {
            LOGGER.error("Error en autenticacionUsuario " + e.getMessage());
            LOGGER.error("Error en autenticacionUsuario  ", e);

            try {
                UserAuthenticationException exception = objectMapper.readValue(response, UserAuthenticationException.class);
                LOGGER.info(" UserAuthenticationException:" + exception);

                throw new ServiceException(exception.getException(), e);

            } catch (Throwable throwable) {
                throw new ServiceException(throwable.getMessage(), throwable);
            }

        }

        return out;

    }

    private String postRequest(String method, Object object) {
        LOGGER.info(" --- postRequest --- ");
        LOGGER.info(" method: "+method);

        String stringResponse = "";
        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();

        try {

            String json = mapper.writeValueAsString(object);

            LOGGER.info(" --- json --- " + json);

            RequestBody body = RequestBody.create(Constantes.JSON_MEDIA_TYPE, json);
            Request request = new Request.Builder().url(autenticacionURL+method).post(body).addHeader(SecurityConstants.HEADER_AUTHORIZACION_KEY, token).build();

            try (Response response = client.newCall(request).execute()) {
                if (response.code() == 200)
                    stringResponse = response.body().string();
                else
                    return null;

            }

            LOGGER.info(" --- stringResponse --- " + stringResponse);

        } catch (Throwable ex) {
            LOGGER.error("Throwable en postRequest " + ex.getMessage());
            LOGGER.error("Throwable en postRequest ", ex);
            throw new ServiceException(ex.getMessage(), ex);
        }
        return stringResponse;

    }

}
