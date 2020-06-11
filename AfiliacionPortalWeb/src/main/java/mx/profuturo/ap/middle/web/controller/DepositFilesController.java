package mx.profuturo.ap.middle.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.servlet.http.HttpServletResponse;

import mx.profuturo.ap.middle.modelo.global.ResponseError;
import mx.profuturo.ap.middle.modelo.in.DepositFilesB64In;
import mx.profuturo.ap.middle.modelo.out.DepositFilesB64Out;
import mx.profuturo.ap.middle.service.DepositFilesService;
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
@RequestMapping(value = "/middle/deposit-files")
@Api(value = "DepositFilesController", tags = { "Servicio para operaciones tipo carga archivos." })
public class DepositFilesController extends UtilConversor {
    private static final Logger LOGGER = Logger.getLogger(DepositFilesController.class);

    @Autowired
    private DepositFilesService depositFilesService;

    @ApplicationAudit("Carga de archivo csv en base 64.")
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    @ApiOperation(value = "Carga de archivo csv en base 64.", notes = "Carga de archivo csv en base 64..")
    @ApiResponses(value = { @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "PETICION INCORRECTA", response = ResponseError.class),
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "SUCCESS", response = DepositFilesB64Out.class),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "ERROR EN EL SERVICIO", response = ResponseError.class),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "NO SE ENCONTRO INFORMACION", response = ResponseError.class)

    })
    public DepositFilesB64Out cargaArchivo(@RequestBody DepositFilesB64In in) {
        LOGGER.info(" --- cargaArchivo  ----  ");
        LOGGER.info("Request cargaArchivo  ::: " + parseToJson(in));

        DepositFilesB64Out out = depositFilesService.cargaArchivo(in);

        return out;
    }
}
