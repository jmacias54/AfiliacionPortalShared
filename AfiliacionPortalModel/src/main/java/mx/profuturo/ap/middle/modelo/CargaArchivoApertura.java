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
@ApiModel(value = "CargaArchivoApertura", description = "Objeto Request para la carga del archivo apertura de afore movil.")
public class CargaArchivoApertura {
    
    @ApiModelProperty(value = "Nombre del archivo.", required = true)
    private String nombreArchivo;
    
    
    @ApiModelProperty(value = "Base64 del archivo.", required = true)
    private String archivoBase64;

}
