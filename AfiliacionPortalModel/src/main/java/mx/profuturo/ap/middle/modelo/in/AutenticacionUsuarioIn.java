package mx.profuturo.ap.middle.modelo.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.profuturo.ap.middle.modelo.AutenticacionUsuario;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "AutenticacionUsuarioIn", description = "Objeto Request para el Login del Usuario.")
public class AutenticacionUsuarioIn {
	
	
	@ApiModelProperty(value = "Objeto request con las credenciales para acceso o login.", required = true)
	private AutenticacionUsuario rqt;

}
