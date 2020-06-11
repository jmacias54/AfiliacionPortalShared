package mx.profuturo.ap.middle.modelo.in;

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
@ApiModel(value = "ActualizaCodaceIn", description = "Objeto Request para el servicio de actualizacion codace de afore movil.")
public class ActualizaCodaceIn {

    @ApiModelProperty(value = "CURP.", required = true)
    private String curp;

    @ApiModelProperty(value = "Resultado CODACE.", required = true)
    private String resultadoCodace;

}
