package mx.profuturo.ap.middle.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import mx.profuturo.ap.middle.modelo.CatalogoItem;
import mx.profuturo.ap.middle.modelo.global.ResponseError;
import mx.profuturo.ap.middle.service.CatalogoService;
import mx.profuturo.ap.middle.web.annotation.ApplicationAudit;
import mx.profuturo.ap.middle.web.util.UtilConversor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/middle/catalogo")
@Api(value = "CatalogoController", tags = { "Servicio para Catalogos" })
public class CatalogoController extends UtilConversor {
	private static final Logger LOGGER = Logger.getLogger(CatalogoController.class);

	@Autowired
	private CatalogoService catalogoService;

	@ApplicationAudit(" Catalogos")
	@RequestMapping(value = "/{idCatalogo}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " Catalogos", notes = "obtener lista catalogos por el id catalogo.")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "PETICION INCORRECTA", response = ResponseError.class),
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "SUCCESS", response = CatalogoItem[].class),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "ERROR EN EL SERVICIO", response = ResponseError.class),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "NO SE ENCONTRO INFORMACION", response = ResponseError.class)

	})
	public List<CatalogoItem> obtenerCatalogo(@PathVariable("idCatalogo") Integer idCatalogo) {
		LOGGER.info(" --- obtenerCatalogo [ CatalogoController ] ----  ");
		LOGGER.info("Request obtenerCatalogo IN ::: " + parseToJson(idCatalogo));

		List<CatalogoItem> out = catalogoService.obtenerCatalogoPorId(idCatalogo);

		LOGGER.info("Response obtenerCatalogo OUT ::: " + parseToJson(out));

		return out;
	}

}
