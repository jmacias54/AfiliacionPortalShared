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
@ApiModel(value = "RegistroIRN", description = "Objeto response de la operacion de consulta IRN.")
public class RegistroIRN {

    @JsonProperty("fechaInicioVigencia")
    @ApiModelProperty(value = "fecha inicio vigencia.", required = true)
    private String fechaInicioVigencia;
    
    @JsonProperty("fechaFinVigencia")
    @ApiModelProperty(value = "fecha fin vigencia.", required = true)
    private String fechaFinVigencia;
    
    @JsonProperty("grupoTrabajadorSiefore")
    @ApiModelProperty(value = "Grupo Trabajador Siefore.", required = true)
    private int grupoTrabajadorSiefore;
    
    @JsonProperty("claveAdministradora")
    @ApiModelProperty(value = "Clave Administradora.", required = true)
    private double claveAdministradora;
    
    @JsonProperty("comisiones")
    @ApiModelProperty(value = "comisiones.", required = true)
    private double comisiones;
    
    @JsonProperty("porcentajeRendimiento")
    @ApiModelProperty(value = "Porcentaje Rendimiento.", required = true)
    private double porcentajeRendimiento;
    
    @JsonProperty("porcentajeRendimientoReal")
    @ApiModelProperty(value = "Porcentaje Rendimiento Real.", required = true)
    private double porcentajeRendimientoReal;
    
    @JsonProperty("porcentajeRendimientoNominal")
    @ApiModelProperty(value = "Porcentaje Rendimiento Nominal.", required = true)
    private double porcentajeRendimientoNominal;
    
    @JsonProperty("cambioAntesAnio")
    @ApiModelProperty(value = "Cambio Antes de año.", required = true)
    private String cambioAntesAnio;
    
    @JsonProperty("posicionTablaRendimiento")
    @ApiModelProperty(value = "Posicion en la tabla de rendimiento.", required = true)
    private String posicionTablaRendimiento;
    
    @JsonProperty("inicioOperacion")
    @ApiModelProperty(value = "Inicio de la operacion.", required = true)
    private int inicioOperacion;
}
