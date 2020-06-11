package mx.profuturo.ap.middle.web.util;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import mx.profuturo.ap.middle.service.exception.UnknownResourceException;



public class UtilConversor {
	private static final Logger logger = Logger.getLogger(UtilConversor.class);

	public String parseToJson(Object object) {
		try {

			StringBuilder strb = new StringBuilder();
			strb.append("\n");
			strb.append(new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(object));

			return strb.toString();

		} catch (Exception ex) {
			// falta agregar un error global
			logger.error(ex.getMessage());
			throw new UnknownResourceException(ex.getMessage());

		}

	}
}
