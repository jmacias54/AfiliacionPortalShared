package mx.profuturo.ap.middle.service;

import java.util.List;

import mx.profuturo.ap.middle.modelo.CatalogoItem;

public interface CatalogoService {
	List<CatalogoItem> obtenerCatalogoPorId(Integer idCatalogo) ;

}
