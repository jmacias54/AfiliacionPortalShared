package mx.profuturo.ap.middle.service.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.profuturo.ap.middle.modelo.global.Constantes;
import mx.profuturo.ap.middle.service.exception.BadRequestException;

@Component
public class IRNUtilService {
	private static final Logger LOGGER = Logger.getLogger(IRNUtilService.class);

	@Autowired
	private FechasUtilSevice fechasUtilSevice;

	public void validarFormatoFechasVigencia(String fechaInicio, String fechaFin) {
		LOGGER.info(" validar Formato Fechas Vigencia ");
		LOGGER.debug(" fechaInicio : "+fechaInicio);
		LOGGER.debug(" fechaFin : "+fechaFin);


		if (!fechasUtilSevice.isValid(fechaInicio, Constantes.FECHA_FORMATO_SLASH_DD_MM_YYYY))
			throw new BadRequestException("El formato de la fecha inicio vigencia , es invalido.");

		if (!fechasUtilSevice.isValid(fechaFin, Constantes.FECHA_FORMATO_SLASH_DD_MM_YYYY))
			throw new BadRequestException("El formato de la fecha fin vigencia , es invalido.");

	}

}
