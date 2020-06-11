import requestSrv from '../../../index'

function cargaArchivo (nombreArchivo, archivoBase64) {
      return new Promise((resolve, reject) => {
        requestSrv({
            path: 'middle/registro/afore-movil/apertura-cuentas/carga-archivo/',
            method: 'POST',
            data: {

                nombreArchivo,
                archivoBase64,

            },
        })
            .then(res => {
                resolve(res)
            })
            .catch(error => {
                reject(error)
            })
    })
}

function actualizaCodace (curp, resultadoCodace) {
    return new Promise((resolve, reject) => {
        requestSrv({
            path: 'middle/registro/afore-movil/apertura-cuentas/actualiza-codace/',
            method: 'POST',
            data: {

                curp,
                resultadoCodace,

            },
        })
            .then(res => {
                resolve(res)
            })
            .catch(error => {
                reject(error)
            })
    })
}

export default {
    cargaArchivo,
    actualizaCodace,

}
