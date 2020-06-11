package mx.profuturo.ap.middle.service.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import mx.profuturo.ap.middle.modelo.global.Constantes;
import mx.profuturo.ap.middle.service.exception.ServiceException;

@Component
public class FechasUtilSevice {
	private static final Logger LOGGER = Logger.getLogger(FechasUtilSevice.class);

	public boolean isValid(String fecha, String format) {
		LOGGER.info(" -- formato Fecha DDMMYY -- ");

		DateFormat sdf = new SimpleDateFormat(format);
		sdf.setLenient(false);
		try {
			sdf.parse(fecha);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	public String formatoFechaSlashDDMMYY(String fecha) {
		LOGGER.info(" -- formato Fecha DD/MM/YY -- ");
		LOGGER.info(" fecha: " + fecha);

		SimpleDateFormat formatter = new SimpleDateFormat(Constantes.FECHA_FORMATO_SLASH_DD_MM_YYYY);
		DateFormat df = new SimpleDateFormat(Constantes.FECHA_FORMATO_SLASH_DD_MM_YY);

		try {

			Date dFecha = formatter.parse(fecha);
			return df.format(dFecha);

		} catch (ParseException e) {
			e.printStackTrace();
			throw new ServiceException("Error parseo de fecha ," + e.getMessage());

		}

	}
}
