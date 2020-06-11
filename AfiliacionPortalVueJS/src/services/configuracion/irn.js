import requestSrv from '../index'

function consultaIRN(fechaInicioVigencia, fechaFinVigencia) {
  return new Promise((resolve, reject) => {
    requestSrv({
      path: 'middle/irn/consulta',
      method: 'POST',
      data: {
        fechaInicioVigencia,
        fechaFinVigencia,
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
function actualizaIRN(fechaInicioVigencia, fechaFinVigencia, inicioOperacion) {


  return new Promise((resolve, reject) => {
    requestSrv({
      path: 'middle/irn/actualizar',
      method: 'POST',
      data: {
        fechaInicioVigencia,
        fechaFinVigencia,
        inicioOperacion,
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
  consultaIRN,
  actualizaIRN,
}
