package mx.profuturo.ap.middle.service;

import mx.profuturo.ap.middle.modelo.in.DepositFilesB64In;
import mx.profuturo.ap.middle.modelo.out.DepositFilesB64Out;

public interface DepositFilesService {

    DepositFilesB64Out cargaArchivo(DepositFilesB64In in);
}
