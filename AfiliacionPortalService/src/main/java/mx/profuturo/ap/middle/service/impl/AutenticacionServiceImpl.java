package mx.profuturo.ap.middle.service.impl;

import mx.profuturo.ap.middle.modelo.AutenticacionUsuario;
import mx.profuturo.ap.middle.modelo.ConsultaInformacionUsuario;
import mx.profuturo.ap.middle.modelo.Usuario;
import mx.profuturo.ap.middle.modelo.global.Constantes;
import mx.profuturo.ap.middle.modelo.out.AutenticacionUsuarioOut;
import mx.profuturo.ap.middle.service.AutenticacionService;
import mx.profuturo.ap.middle.service.helper.AutenticacionRestCalling;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {
    private static final Logger LOGGER = Logger.getLogger(AutenticacionService.class);

    @Autowired
    private AutenticacionRestCalling _callRestTemplateToken;

    @Override
    public AutenticacionUsuarioOut autenticacionUsuario(AutenticacionUsuario in) {
        LOGGER.info(" --- autenticacionUsuario  ----  ");
        LOGGER.info(" AutenticacionUsuarioIn Request : " + in);

        in.setAplicacion(Constantes.APPLICATION_AUTH);
        AutenticacionUsuarioOut out = _callRestTemplateToken.autenticacionUsuario(in);

        return out;

    }

    @Override
    public Usuario consultaInformacionUsuario(ConsultaInformacionUsuario in) {
        LOGGER.info(" ConsultaInformacionUsuario Request : " + in);

        Usuario out = _callRestTemplateToken.consultaInformacionUsuario(in);

        return out;

    }

}
