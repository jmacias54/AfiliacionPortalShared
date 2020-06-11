package mx.profuturo.ap.middle.modelo.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ActualizaIRNOut", description = "Objeto Response para la operacion de actualizcion IRN.")
public class ActualizaIRNOut {

    
    @JsonProperty("result")
    @ApiModelProperty(value = "Estatus booleano del Resultado.", required = true)
    private boolean result;
    
    @JsonProperty("mensaje")
    @ApiModelProperty(value = "Mensaje respuesta.", required = true) 
    private String mensaje;
    
    @JsonProperty("descripcionMensaje")
    @ApiModelProperty(value = "Descripcion Mensaje.", required = true) 
    private String descripcionMensaje;
}
