package mx.profuturo.ap.middle.service.impl;

import mx.profuturo.ap.middle.modelo.CargaArchivoApertura;
import mx.profuturo.ap.middle.modelo.global.AforeMovilMethodsConstants;
import mx.profuturo.ap.middle.modelo.in.ActualizaCodaceIn;
import mx.profuturo.ap.middle.modelo.out.AforeMovilResponseOut;
import mx.profuturo.ap.middle.modelo.rqt.ActualizaCodaceRqt;
import mx.profuturo.ap.middle.modelo.rqt.CargaArchivoAperturaRqtIn;
import mx.profuturo.ap.middle.service.AforeMovilService;
import mx.profuturo.ap.middle.service.helper.RestTemplateHelper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;



@Service
@PropertySource(value={"classpath:application.properties"})
public class AforeMovilServiceImpl implements AforeMovilService {
    private static final Logger LOGGER = Logger.getLogger(AforeMovilServiceImpl.class);

    @Autowired
    private RestTemplateHelper restTemplateHelper;

    @Value("${url.aforemovil}")
    private String urlAforeMovil;

    @Override
    public AforeMovilResponseOut cargaArchivoAperturaCuentas(CargaArchivoApertura in) {
        LOGGER.info(" --- Carga Archivo Apertura Cuentas  ----  ");
        LOGGER.info(" CargaArchivoAperturaRqtIn : " + in);
        LOGGER.info(" urlCargaArchivoApertura : " + urlAforeMovil);
        
        CargaArchivoAperturaRqtIn rqt = CargaArchivoAperturaRqtIn.builder().rqt(in).build();

        AforeMovilResponseOut out = restTemplateHelper.postForEntity(AforeMovilResponseOut.class, urlAforeMovil + AforeMovilMethodsConstants.METHOD_ARCHIVO_APERTURA, rqt);

        return out;
    }

    @Override
    public AforeMovilResponseOut actualizaCodace(ActualizaCodaceIn in) {
        LOGGER.info(" --- Actualiza CODACE   ----  ");
        LOGGER.info(" ActualizaCodaceIn : " + in);
        LOGGER.info(" url : " + urlAforeMovil);
        
        ActualizaCodaceRqt rqt = ActualizaCodaceRqt.builder().rqt(in).build();

        AforeMovilResponseOut out = restTemplateHelper.postForEntity(AforeMovilResponseOut.class, urlAforeMovil + AforeMovilMethodsConstants.METHOD_ACTUALIZA_CODACE, rqt);

        return out;
    }
}
