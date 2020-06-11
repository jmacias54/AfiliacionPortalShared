package mx.profuturo.ap.middle.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.servlet.http.HttpServletResponse;

import mx.profuturo.ap.middle.modelo.global.ResponseError;
import mx.profuturo.ap.middle.modelo.in.ActualizaIRNIn;
import mx.profuturo.ap.middle.modelo.in.ConsultaIRNIn;
import mx.profuturo.ap.middle.modelo.out.ActualizaIRNOut;
import mx.profuturo.ap.middle.modelo.out.RegistrosIRNListOut;
import mx.profuturo.ap.middle.service.IRNService;
import mx.profuturo.ap.middle.web.annotation.ApplicationAudit;
import mx.profuturo.ap.middle.web.util.UtilConversor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/middle/irn")
@Api(value = "IRNController", tags = { "Servicio para operaciones IRN" })
public class IRNController extends UtilConversor {
    private static final Logger LOGGER = Logger.getLogger(IRNController.class);
    
    @Autowired
    private IRNService irnService;

    @ApplicationAudit("Consulta IRN ")
    @RequestMapping(value = "/consulta", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    @ApiOperation(value = "Consulta IRN", notes = "Consulta IRN.")
    @ApiResponses(value = { @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "PETICION INCORRECTA", response = ResponseError.class),
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "SUCCESS", response = RegistrosIRNListOut.class),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "ERROR EN EL SERVICIO", response = ResponseError.class),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "NO SE ENCONTRO INFORMACION", response = ResponseError.class)

    })
    public RegistrosIRNListOut consultaIRN(@RequestBody ConsultaIRNIn in) {
        LOGGER.info(" --- consultaIRN  ----  ");
        LOGGER.info("Request consultaIRN  ::: " + parseToJson(in));

        RegistrosIRNListOut out = irnService.consultaIRN(in);

        return out;
    }

    @ApplicationAudit("Actualizar IRN ")
    @RequestMapping(value = "/actualizar", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    @ApiOperation(value = "Actualizar IRN", notes = "Actualizar IRN.")
    @ApiResponses(value = { @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "PETICION INCORRECTA", response = ResponseError.class),
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "SUCCESS", response = ActualizaIRNOut.class),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "ERROR EN EL SERVICIO", response = ResponseError.class),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "NO SE ENCONTRO INFORMACION", response = ResponseError.class)

    })
    public ActualizaIRNOut actualizarIRN(@RequestBody ActualizaIRNIn in) {
        LOGGER.info(" --- actualizarIRN  ----  ");
        LOGGER.info("Request actualizarIRN  ::: " + parseToJson(in));

        ActualizaIRNOut out = irnService.actualizarIRN(in);

        return out;
    }
    
    
}
