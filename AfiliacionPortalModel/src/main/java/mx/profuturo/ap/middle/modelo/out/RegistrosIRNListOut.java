package mx.profuturo.ap.middle.modelo.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.profuturo.ap.middle.modelo.RegistroIRN;

import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "RegistrosIRNListOut", description = "Objeto response de la operacion de consulta IRN.")
public class RegistrosIRNListOut {
    
    @JsonProperty("registrosIRN")
    @ApiModelProperty(value = "Lista de registros IRN.", required = true)
    private List<RegistroIRN> registrosIRN;

}
