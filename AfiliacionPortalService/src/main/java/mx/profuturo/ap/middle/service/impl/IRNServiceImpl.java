package mx.profuturo.ap.middle.service.impl;

import mx.profuturo.ap.middle.modelo.in.ActualizaIRNIn;
import mx.profuturo.ap.middle.modelo.in.ConsultaIRNIn;
import mx.profuturo.ap.middle.modelo.out.ActualizaIRNOut;
import mx.profuturo.ap.middle.modelo.out.RegistrosIRNListOut;
import mx.profuturo.ap.middle.service.IRNService;
import mx.profuturo.ap.middle.service.helper.RestTemplateHelper;
import mx.profuturo.ap.middle.service.util.FechasUtilSevice;
import mx.profuturo.ap.middle.service.util.IRNUtilService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


@Service
@PropertySource(value={"classpath:application.properties"})
public class IRNServiceImpl implements IRNService {
    private static final Logger LOGGER = Logger.getLogger(IRNServiceImpl.class);

    @Autowired
    private RestTemplateHelper restTemplateHelper;

    @Value("${url.consulta.irn}")
    private String urlConsultaIRN;
    
    @Value("${url.actualiza.irn}")
    private String urlActualizaIRN;
    
    @Autowired
    private FechasUtilSevice fechasUtilSevice;
    
    @Autowired
    private  IRNUtilService irnUtilService;
    
    

    @Override
    public RegistrosIRNListOut consultaIRN(ConsultaIRNIn in) {
        LOGGER.info(" --- consultaIRN  ----  ");
        LOGGER.debug(" ConsultaIRNIn : " + in);
        LOGGER.debug(" urlConsultaIRN : " + urlConsultaIRN);

        
        irnUtilService.validarFormatoFechasVigencia(in.getFechaInicioVigencia(), in.getFechaFinVigencia());
                
        String fechaInicioFormato = fechasUtilSevice.formatoFechaSlashDDMMYY(in.getFechaInicioVigencia());
        in.setFechaInicioVigencia(fechaInicioFormato);
        String fechaFinFormato = fechasUtilSevice.formatoFechaSlashDDMMYY(in.getFechaFinVigencia());
        in.setFechaFinVigencia(fechaFinFormato);

        LOGGER.debug(" ConsultaIRNIn : " + in);

        RegistrosIRNListOut out = restTemplateHelper.postForEntity(RegistrosIRNListOut.class, urlConsultaIRN, in);

        return out;
    }



    @Override
    public ActualizaIRNOut actualizarIRN(ActualizaIRNIn in) {
        LOGGER.info(" --- actualizarIRN  ----  ");
        LOGGER.debug(" ActualizaIRNIn : " + in);
        LOGGER.debug(" urlActualizaIRN : " + urlActualizaIRN);
        
        
        irnUtilService.validarFormatoFechasVigencia(in.getFechaInicioVigencia(), in.getFechaFinVigencia());


        String fechaInicioFormato = fechasUtilSevice.formatoFechaSlashDDMMYY(in.getFechaInicioVigencia());
        in.setFechaInicioVigencia(fechaInicioFormato);
        String fechaFinFormato = fechasUtilSevice.formatoFechaSlashDDMMYY(in.getFechaFinVigencia());
        in.setFechaFinVigencia(fechaFinFormato);

        ActualizaIRNOut out = restTemplateHelper.postForEntity(ActualizaIRNOut.class, urlActualizaIRN, in);

        return out;
    }
}
