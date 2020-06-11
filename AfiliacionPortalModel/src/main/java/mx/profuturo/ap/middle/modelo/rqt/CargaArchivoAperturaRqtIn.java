package mx.profuturo.ap.middle.modelo.rqt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.profuturo.ap.middle.modelo.CargaArchivoApertura;



@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "CargaArchivoAperturaRqtIn", description = "Objeto Request para la carga del archivo apertura de afore movil.")
public class CargaArchivoAperturaRqtIn {

    @ApiModelProperty(value = "Objeto request para la carga de archivo.", required = true)
    private CargaArchivoApertura rqt;
}
