package mx.profuturo.ap.middle.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.profuturo.ap.middle.modelo.CatalogoItem;
import mx.profuturo.ap.middle.service.CatalogoService;
import mx.profuturo.ap.middle.service.exception.ServiceException;
import mx.profuturo.ap.middle.service.helper.RestTemplateHelper;

@Service
public class CatalogoServiceImpl implements CatalogoService {
	private static final Logger LOGGER = Logger.getLogger(CatalogoServiceImpl.class);

	@Autowired
	private RestTemplateHelper restTemplateHelper;

	@Override
	public List<CatalogoItem> obtenerCatalogoPorId(Integer idCatalogo) {
		LOGGER.info(" --- obtenerCatalogoPorId [ CatalogoService ] ----  ");

		try {

			return restTemplateHelper.getForList(CatalogoItem.class,
					"http://172.16.60.69:7903/v1/iib/afiliacion/catalogos/" + idCatalogo);

		} catch (Exception ex) {
			LOGGER.error("  obtenerCatalogoPorId [ CatalogoService ]: " + ex.getMessage());
			LOGGER.error("  obtenerCatalogoPorId [ CatalogoService ]: ", ex);
			throw new ServiceException(ex.getMessage());
		}
	}

}
