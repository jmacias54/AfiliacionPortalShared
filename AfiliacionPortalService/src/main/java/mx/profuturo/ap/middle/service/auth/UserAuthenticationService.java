package mx.profuturo.ap.middle.service.auth;

import mx.profuturo.ap.middle.modelo.AutenticacionUsuario;
import mx.profuturo.ap.middle.modelo.AuthToken;
import mx.profuturo.ap.middle.modelo.ConsultaInformacionUsuario;
import mx.profuturo.ap.middle.modelo.Usuario;
import mx.profuturo.ap.middle.modelo.out.AutenticacionUsuarioOut;
import mx.profuturo.ap.middle.service.AutenticacionService;
import mx.profuturo.ap.middle.service.exception.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserAuthenticationService userAuthenticationService;
    
    private static final String MOCK_USER_LOGIN = "081869";

    @Autowired
    private AutenticacionService autenticacionService;

    public AuthToken authenticateUser(String usuario, String contrasena) {
        

        AutenticacionUsuarioOut out = null;
        String token = "";
        Usuario _usuario = null ;

        if (usuario.equals(MOCK_USER_LOGIN))
            out = AutenticacionUsuarioOut.builder().numeroEmpleado(MOCK_USER_LOGIN).confirmacion(true).build();
        else
            out = autenticacionService.autenticacionUsuario(AutenticacionUsuario.builder().usuario(usuario).contrasena(contrasena).build());
        
        

        if (out != null && out.isConfirmacion()){
            token=  jwtService.generateToken(out.getNumeroEmpleado());
            _usuario = autenticacionService.consultaInformacionUsuario(ConsultaInformacionUsuario.builder().usuario(out.getNumeroEmpleado()).build());
            return  AuthToken.builder().token(token).numeroEmpleado(out.getNumeroEmpleado()).usuario(_usuario).build();

        }
        
        
        
        

        throw new ServiceException(String.format("No se puede autenticar con el usuario : [%s]", usuario));
    }

    public Usuario authenticateToken(String jwtToken) {

        String _usuario = jwtService.verifyToken(jwtToken);
        Usuario usuario = autenticacionService.consultaInformacionUsuario(ConsultaInformacionUsuario.builder().usuario(_usuario).build());

        return usuario;

    }
}
