package mx.profuturo.ap.middle.modelo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "AdditionalData", description = "Objeto Request para la operacion de carga de archivos para el api de DepositFilesB64.")
public class AdditionalData {

    @JsonProperty("name")
    @ApiModelProperty(value = "path a depositar el archivo.", required = true)
    private String name;

    @JsonProperty("value")
    private String value;
}
