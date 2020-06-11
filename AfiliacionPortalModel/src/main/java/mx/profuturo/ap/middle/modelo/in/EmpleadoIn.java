package mx.profuturo.ap.middle.modelo.in;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "EmpleadoIn", description = "Objeto Request para la operacion.")
public class EmpleadoIn implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idEmpleado;

}
