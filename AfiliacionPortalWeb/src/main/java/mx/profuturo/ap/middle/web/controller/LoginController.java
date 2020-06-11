package mx.profuturo.ap.middle.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.servlet.http.HttpServletResponse;

import mx.profuturo.ap.middle.modelo.AutenticacionUsuario;
import mx.profuturo.ap.middle.modelo.AuthToken;
import mx.profuturo.ap.middle.modelo.ConsultaInformacionUsuario;
import mx.profuturo.ap.middle.modelo.Usuario;
import mx.profuturo.ap.middle.modelo.global.ResponseError;
import mx.profuturo.ap.middle.service.AutenticacionService;
import mx.profuturo.ap.middle.service.auth.UserAuthenticationService;
import mx.profuturo.ap.middle.web.annotation.ApplicationAudit;
import mx.profuturo.ap.middle.web.util.UtilConversor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/middle")
@Api(value = "LoginController", tags = { "Autenticacion de usuario" })
public class LoginController extends UtilConversor {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    @Autowired
    private AutenticacionService autenticacionService;

    @Autowired
    private UserAuthenticationService authenticationService;

    @ApplicationAudit("Autenticacion del Usuario.")
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Autenticacion del Usuario.", notes = "obtener informacion del loggeo del usuario.")
    @ApiResponses(value = { @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "PETICION INCORRECTA", response = ResponseError.class),
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "SUCCESS", response = AuthToken.class),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "ERROR EN EL SERVICIO", response = ResponseError.class),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "NO SE ENCONTRO INFORMACION", response = ResponseError.class)

    })
    public AuthToken autenticacionUsuario(@RequestBody AutenticacionUsuario in) {
        LOGGER.info(" --- autenticacionUsuario [ LoginController ] ----  ");
        LOGGER.info("Request Autenticacion Usuario IN ::: " + parseToJson(in));


        AuthToken out  = authenticationService.authenticateUser(in.getUsuario(), in.getContrasena());

        return out;

    }

    @ApplicationAudit("Obtener informacion del Usuario.")
    @RequestMapping(value = "/consulta-informacion/usuario", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Obtener informacion del Usuario.", notes = "obtener informacion del usuario.")
    @ApiResponses(value = { @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "PETICION INCORRECTA", response = ResponseError.class),
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "SUCCESS", response = Usuario.class),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "ERROR EN EL SERVICIO", response = ResponseError.class),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "NO SE ENCONTRO INFORMACION", response = ResponseError.class)

    })
    public Usuario consultaInformacionUsuario(@RequestBody ConsultaInformacionUsuario in) {
        LOGGER.info(" --- consultaInformacionUsuario [ LoginController ] ----  ");
        LOGGER.info("Request Consulta Informacion Usuario IN ::: " + parseToJson(in));

        Usuario out = autenticacionService.consultaInformacionUsuario(in);

        LOGGER.info("Response Consulta Informacion Usuario  OUT ::: " + parseToJson(out));

        return out;
    }
}
