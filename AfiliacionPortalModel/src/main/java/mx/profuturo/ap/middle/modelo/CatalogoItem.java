package mx.profuturo.ap.middle.modelo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "CatalogoItem", description = "Objeto response item para el servicio de catalogo.")
public class CatalogoItem {

	@ApiModelProperty(value = "claveAlfanumerica", required = true)
	private String claveAlfanumerica;
	@ApiModelProperty(value = "claveNumerica", required = true)
	private BigDecimal claveNumerica;
	@ApiModelProperty(value = "descripcion", required = true)
	private String description;
	@ApiModelProperty(value = "idElemento", required = true)
	private BigDecimal idElement;
	@ApiModelProperty(value = "vigencia", required = true)
	private BigDecimal vigencia;

}
