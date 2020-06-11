package mx.profuturo.ap.middle.modelo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Usuario", description = "Objeto Response con la informacion del Usuario.")
public class Usuario {

	@ApiModelProperty(value = "Apellido Materno del Usuario.", required = true)
	private String apellidoMaterno;
	@ApiModelProperty(value = "Apellido Paterno del Usuario.", required = true)
	private String apellidoPaterno;
	@ApiModelProperty(value = "Nombre del Usuario.", required = true)
	private String nombre;
	@ApiModelProperty(value = "Clave Consar.", required = true)
	private String claveConsar;
	@ApiModelProperty(value = "CURP del Usuario.", required = true)
	private String curp;
	@ApiModelProperty(value = "Fecha Alta Consar del Usuario.", required = true)
	private String fechaAltaConsar;
	@ApiModelProperty(value = "Numero Empleado del Usuario.", required = true)
	private String numeroEmpleado;
	@ApiModelProperty(value = "Identificador del Usuario.", required = true)
	private String userId;
	@ApiModelProperty(value = "Centro Costo del Usuario.", required = true)
	private BigDecimal centroCosto;
	@ApiModelProperty(value = "Correo Electronico del Usuario.", required = true)
	private String email;
	
}
