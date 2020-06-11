package mx.profuturo.ap.middle.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.servlet.http.HttpServletResponse;

import mx.profuturo.ap.middle.modelo.CargaArchivoApertura;
import mx.profuturo.ap.middle.modelo.global.ResponseError;
import mx.profuturo.ap.middle.modelo.in.ActualizaCodaceIn;
import mx.profuturo.ap.middle.modelo.out.AforeMovilResponseOut;
import mx.profuturo.ap.middle.service.AforeMovilService;
import mx.profuturo.ap.middle.web.annotation.ApplicationAudit;
import mx.profuturo.ap.middle.web.util.UtilConversor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/middle/registro/afore-movil/")
@Api(value = "AforeMovilController", tags = { "carga-archivo-afore-movil" })
public class AforeMovilController extends UtilConversor {
    private static final Logger logger = Logger.getLogger(AforeMovilController.class);
    
    
    @Autowired
    private AforeMovilService aforeMovilService;

    @ApplicationAudit("Carga Archivo , Apertura de Cuentas.")
	@RequestMapping(value = "/apertura-cuentas/carga-archivo/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Carga Archivo , Apertura de Cuentas.", notes = "Carga Archivo , Apertura de Cuentas.")
	@ApiResponses(value = {

			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "PETICION INCORRECTA", response = ResponseError.class),
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success", response = AforeMovilResponseOut.class),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "ERROR EN EL SERVICIO", response = ResponseError.class),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "NO SE ENCONTRO INFORMACION", response = ResponseError.class) })
	public AforeMovilResponseOut cargaArchivoAperturaCuentas(@RequestBody CargaArchivoApertura in) {
		logger.info(" --- Carga Archivo , Apertura de Cuentas  ----  ");
		logger.info("Request Carga Archivo , Apertura de Cuentas  IN ::: " + parseToJson(in));

		AforeMovilResponseOut out = aforeMovilService.cargaArchivoAperturaCuentas(in);
		return out ;
	}
    
    
   
    @ApplicationAudit("Actualiza CODACE.")
    @RequestMapping(value = "/apertura-cuentas/actualiza-codace/", method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Actualiza CODACE.", notes = "Actualiza CODACE")
    @ApiResponses(value = {

            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "PETICION INCORRECTA", response = ResponseError.class),
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "Success", response = AforeMovilResponseOut.class),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "ERROR EN EL SERVICIO", response = ResponseError.class),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "NO SE ENCONTRO INFORMACION", response = ResponseError.class) })
    public AforeMovilResponseOut actualizaCodace(@RequestBody ActualizaCodaceIn in) {
        logger.info(" --- Actualiza CODACE ----  ");
        logger.info("Request ::: " + parseToJson(in));

        AforeMovilResponseOut out = aforeMovilService.actualizaCodace(in);
        return out ;
    }
}
