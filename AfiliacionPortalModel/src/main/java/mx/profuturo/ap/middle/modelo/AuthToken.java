package mx.profuturo.ap.middle.modelo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "AuthToken", description = "Objeto respuesta de login.")
public class AuthToken {

    @JsonProperty("token")
    @ApiModelProperty(value = "Token.", required = true)
    private String token;
    
    @JsonProperty("username")
    @ApiModelProperty(value = "Numero de empleado.", required = true)
    private String numeroEmpleado;
    
    @JsonProperty("usuario")
    @ApiModelProperty(value = "Objet usuario que contiene informacion correspondiente.", required = true)
    private Usuario usuario;

}
