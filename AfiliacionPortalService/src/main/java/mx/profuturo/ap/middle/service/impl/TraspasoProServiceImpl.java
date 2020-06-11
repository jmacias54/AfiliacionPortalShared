package mx.profuturo.ap.middle.service.impl;

import java.util.List;

import mx.profuturo.ap.middle.modelo.CatalogoItem;
import mx.profuturo.ap.middle.modelo.out.CatalogoOut;
import mx.profuturo.ap.middle.service.TraspasoProService;
import mx.profuturo.ap.middle.service.exception.ServiceException;
import mx.profuturo.ap.middle.service.helper.RestTemplateHelper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraspasoProServiceImpl implements TraspasoProService {
	private static final Logger LOGGER = Logger.getLogger(TraspasoProServiceImpl.class);

	@Autowired
	private RestTemplateHelper restTemplateHelper;

	@Override
	public CatalogoOut obtenerInhabilitacionCatalogos(Integer idCatalogo) {

		LOGGER.info(" --- obtenerInhabilitacionCatalogos [ InhabilitacionTraspasoProService ] ----  ");

		try {

			List<CatalogoItem> lista  =  restTemplateHelper.getForList(CatalogoItem.class,"http://172.16.60.69:7903/v1/iib/afiliacion/catalogos/" + idCatalogo);

			
			return CatalogoOut.builder().elementos(lista).build();

		} catch (Exception ex) {
			LOGGER.error("  obtenerInhabilitacionCatalogos [ InhabilitacionTraspasoProService ]: " + ex.getMessage());
			LOGGER.error("  obtenerInhabilitacionCatalogos [ InhabilitacionTraspasoProService ]: ", ex);
			throw new ServiceException(ex.getMessage());
		}
	}

}
