package mx.profuturo.ap.middle.modelo.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@ApiModel(value = "AforeMovilResponseOut", description = "Objeto Response para la carga del archivo apertura de afore movil.")
public class AforeMovilResponseOut {

    @ApiModelProperty(value = "Estatus de la operacion.", required = true)
    private boolean success;
    @ApiModelProperty(value = "Mensaje del resultado de la operacion.", required = true)
    private String message;

}
