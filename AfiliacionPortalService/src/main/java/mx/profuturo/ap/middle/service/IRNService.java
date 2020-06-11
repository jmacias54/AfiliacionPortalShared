package mx.profuturo.ap.middle.service;

import mx.profuturo.ap.middle.modelo.in.ActualizaIRNIn;
import mx.profuturo.ap.middle.modelo.in.ConsultaIRNIn;
import mx.profuturo.ap.middle.modelo.out.ActualizaIRNOut;
import mx.profuturo.ap.middle.modelo.out.RegistrosIRNListOut;

public interface IRNService {

    RegistrosIRNListOut consultaIRN(ConsultaIRNIn in);

    ActualizaIRNOut actualizarIRN(ActualizaIRNIn in);

}
