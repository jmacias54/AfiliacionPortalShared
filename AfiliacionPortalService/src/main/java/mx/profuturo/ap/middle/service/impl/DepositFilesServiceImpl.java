package mx.profuturo.ap.middle.service.impl;

import mx.profuturo.ap.middle.modelo.in.DepositFilesB64In;
import mx.profuturo.ap.middle.modelo.out.DepositFilesB64Out;
import mx.profuturo.ap.middle.service.DepositFilesService;
import mx.profuturo.ap.middle.service.helper.RestTemplateHelper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


@Service
@PropertySource(value={"classpath:application.properties"})
public class DepositFilesServiceImpl implements DepositFilesService {
    private static final Logger LOGGER = Logger.getLogger(DepositFilesServiceImpl.class);
    
    
    @Autowired
    private RestTemplateHelper restTemplateHelper;

    @Value("${url.deposit.files}")
    private String urlDepositFiles;

    @Override
    public DepositFilesB64Out cargaArchivo(DepositFilesB64In in) {
        LOGGER.info(" --- cargaArchivo  ----  ");
        LOGGER.info(" DepositFilesB64In : " + in);
        LOGGER.info(" urlDepositFiles : " + urlDepositFiles);


        DepositFilesB64Out out = restTemplateHelper.putForEntity(DepositFilesB64Out.class, urlDepositFiles, in);

        return out;
    }

}
