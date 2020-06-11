package mx.profuturo.ap.middle.modelo.in;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "PrevalidacionOut", description = "Objeto Response para la operacion.")
public class PrevalidacionOut implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1655224281070541890L;
	private String prevalidaciones;
	private String descripcion;
	

}
