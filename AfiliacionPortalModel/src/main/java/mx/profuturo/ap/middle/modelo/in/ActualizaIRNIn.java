package mx.profuturo.ap.middle.modelo.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ActualizaIRNIn", description = "Objeto Request para la operacion de actualizacion IRN.")
public class ActualizaIRNIn extends ConsultaIRNIn {

    @JsonProperty("inicioOperacion")
    @ApiModelProperty(value = "Indicador del inicio de la operacion.", required = true)
    private int inicioOperacion;

}
