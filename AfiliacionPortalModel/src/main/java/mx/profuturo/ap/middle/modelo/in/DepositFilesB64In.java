package mx.profuturo.ap.middle.modelo.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.profuturo.ap.middle.modelo.AdditionalData;

import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "DepositFilesB64In", description = "Objeto Request para la operacion de carga de archivos para el api de DepositFilesB64.")
public class DepositFilesB64In {

    @JsonProperty("Path")
    @ApiModelProperty(value = "path a depositar el archivo.", required = true)
    private String path;
    
    @JsonProperty("FileName")
    @ApiModelProperty(value = "nombre del archivo.", required = true) 
    private String fileName;
    
    @JsonProperty("FileContent")
    @ApiModelProperty(value = "Documento csv en base 64.", required = true) 
    private String fileContent;
    
    @JsonProperty("userId")
    @ApiModelProperty(value = "Identificador del usuario que realiza la operacion.", required = true) 
    private String userId;
    
    @JsonProperty("additionalData")
    @ApiModelProperty(value = "Informacion adicional para el proceso.", required = true) 
    private List<AdditionalData> additionalData;
    

}
