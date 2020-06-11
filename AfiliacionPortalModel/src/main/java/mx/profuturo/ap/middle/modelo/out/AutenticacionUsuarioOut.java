package mx.profuturo.ap.middle.modelo.out;

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
@ApiModel(value = "AutenticacionUsuarioOut", description = "Objeto Response para del Login del Usuario.")
public class AutenticacionUsuarioOut {

	
	@ApiModelProperty(value = "valor booleano para el estatus del acceso.", required = true)
	private boolean confirmacion;
	@ApiModelProperty(value = "Numero del empleado.", required = true)
	private String numeroEmpleado;
	
}
