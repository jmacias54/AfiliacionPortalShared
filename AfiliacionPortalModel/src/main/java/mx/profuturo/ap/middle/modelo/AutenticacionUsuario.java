package mx.profuturo.ap.middle.modelo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "AutenticacionUsuario", description = "Objeto Request que contiene las credenciales para el Login del Usuario.")
public class AutenticacionUsuario {
	
	
	
	@ApiModelProperty(value = "Usuario a loggear.", required = true)
	private String usuario;
	@ApiModelProperty(value = "Aplicacion a donde loggear.", required = true)
	private String aplicacion;
	@ApiModelProperty(value = "Password del usuario.", required = true)
	private String contrasena;

}
