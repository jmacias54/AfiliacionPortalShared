package mx.profuturo.ap.middle.modelo.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.profuturo.ap.middle.modelo.Usuario;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ConsultaInformacionUsuarioOut", description = "Objeto Response con la informacion del Usuario.")
public class ConsultaInformacionUsuarioOut {
	
	@ApiModelProperty(value = "Objeto Response con la informacion del Usuario", required = true)
	private Usuario empleado;
	
	private String Exception;
	
	

}
