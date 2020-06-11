package mx.profuturo.ap.middle.modelo.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.profuturo.ap.middle.modelo.ConsultaInformacionUsuario;



@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ConsultaInformacionUsuarioIn", description = "Objeto Request para obtencion de informacion del Usuario.")
public class ConsultaInformacionUsuarioIn {

	@ApiModelProperty(value = "Objeto request para la obtencion de la informacion del usuario.", required = true)
	private ConsultaInformacionUsuario rqt;

}
