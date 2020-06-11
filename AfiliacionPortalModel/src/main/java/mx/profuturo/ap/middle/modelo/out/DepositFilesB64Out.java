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
@ApiModel(value = "DepositFilesB64Out", description = "Objeto Response para la operacion de carga de archivos para el api de DepositFilesB64.")
public class DepositFilesB64Out {

    @JsonProperty("code")
    @ApiModelProperty(value = "Codigo respuesta.", required = true)
    private String code;
    
    @JsonProperty("message")
    @ApiModelProperty(value = "Mensaje respuesta.", required = true) 
    private String message;
}
