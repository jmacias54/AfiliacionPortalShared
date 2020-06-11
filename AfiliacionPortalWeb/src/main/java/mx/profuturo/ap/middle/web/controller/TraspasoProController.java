package mx.profuturo.ap.middle.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.servlet.http.HttpServletResponse;

import mx.profuturo.ap.middle.modelo.global.ResponseError;
import mx.profuturo.ap.middle.modelo.out.CatalogoOut;
import mx.profuturo.ap.middle.service.TraspasoProService;
import mx.profuturo.ap.middle.web.annotation.ApplicationAudit;
import mx.profuturo.ap.middle.web.util.UtilConversor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping(value = "/middle/traspaso/traspaso-pro/")
@Api( value = "TraspasoProAutenticacionController", tags = {"inhabilitacion Curp"  })
public class TraspasoProController extends UtilConversor {
	private static final Logger LOGGER = Logger.getLogger(TraspasoProController.class);
	
	@Autowired
	private TraspasoProService TraspasoProService ;

	@ApplicationAudit("Inhabilitacion")
	@RequestMapping(value = "/autenticacion/inhabilitacion/{curp}/", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Inhabilitacion", notes = "Inhabilitacion.")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "PETICION INCORRECTA", response = ResponseError.class),
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success", response = CatalogoOut.class), 
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "ERROR EN EL SERVICIO" , response = ResponseError.class),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "NO SE ENCONTRO INFORMACION" , response = ResponseError.class) 
			
	})
	public  CatalogoOut inhabilitacionCurp(@PathVariable("curp") String curp) {
		LOGGER.info(" --- inhabilitacionCurp [ TraspasoProController ] ----  ");
		LOGGER.info("Request inhabilitacion Catalogos IN ::: " + parseToJson(curp));
		
		
		//CatalogoOut out = TraspasoProService.obtenerInhabilitacionCatalogos(idCatalogo);

		//LOGGER.info("Response inhabilitacionCurp OUT ::: " + parseToJson(out));

		return new CatalogoOut();
	}
}
