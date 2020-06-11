package mx.profuturo.ap.middle.service;

import mx.profuturo.ap.middle.modelo.CargaArchivoApertura;
import mx.profuturo.ap.middle.modelo.in.ActualizaCodaceIn;
import mx.profuturo.ap.middle.modelo.out.AforeMovilResponseOut;

public interface AforeMovilService {

    AforeMovilResponseOut cargaArchivoAperturaCuentas(CargaArchivoApertura in);

    AforeMovilResponseOut actualizaCodace(ActualizaCodaceIn in);

}
