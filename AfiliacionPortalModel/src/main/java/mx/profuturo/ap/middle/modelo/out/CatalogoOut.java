package mx.profuturo.ap.middle.modelo.out;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.profuturo.ap.middle.modelo.CatalogoItem;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "CatalogoOut", description = "Objeto response  para el servicio de catalogo.")
public class CatalogoOut {

	@ApiModelProperty(value = "elementos", required = true)
	private List<CatalogoItem> elementos;

}
