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
@ApiModel(value = "ConsultaInformacionUsuario", description = "Objeto Request para obtener informacion del Usuario.")
public class ConsultaInformacionUsuario {

	@ApiModelProperty(value = "CURP del Usuario Loggeado.", required = false)
	private String curp;
	@ApiModelProperty(value = "Numero de empleado del usuario Loggeado.", required = true)
	private String usuario;
}
