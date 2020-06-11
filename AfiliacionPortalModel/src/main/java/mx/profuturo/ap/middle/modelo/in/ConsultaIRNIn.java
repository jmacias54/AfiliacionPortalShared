package mx.profuturo.ap.middle.modelo.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ConsultaIRNIn", description = "Objeto Request para la operacion de consulta IRN.")
public class ConsultaIRNIn {
    
    @JsonProperty("fechaInicioVigencia")
    @ApiModelProperty(value = "fecha inicio vigencia.", required = true)
    private String fechaInicioVigencia;
    
    @JsonProperty("fechaFinVigencia")
    @ApiModelProperty(value = "fecha fin vigencia.", required = true) 
    private String fechaFinVigencia;

}
