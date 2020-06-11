package mx.profuturo.ap.middle.service;

import mx.profuturo.ap.middle.modelo.AutenticacionUsuario;
import mx.profuturo.ap.middle.modelo.ConsultaInformacionUsuario;
import mx.profuturo.ap.middle.modelo.Usuario;
import mx.profuturo.ap.middle.modelo.out.AutenticacionUsuarioOut;

public interface AutenticacionService {
	
	AutenticacionUsuarioOut autenticacionUsuario( AutenticacionUsuario in);
	
	Usuario consultaInformacionUsuario( ConsultaInformacionUsuario in); 

}
