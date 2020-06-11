package mx.profuturo.ap.middle.modelo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {
	
	
	private BigDecimal idPrevalConsultas;
	private String idEmpleado;
	private BigDecimal centroCostos;
	private BigDecimal loteProductivo;
	

}
