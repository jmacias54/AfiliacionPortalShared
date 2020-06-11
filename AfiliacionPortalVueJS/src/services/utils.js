function getBase64(file) {
    if (file != null) {
        return new Promise((resolve, reject) => {
            const reader = new FileReader()
            reader.readAsDataURL(file)
            reader.onload = () => resolve(reader.result.replace('data:', '')
                .replace(/^.+,/, ''))
            reader.onerror = error => reject(error)
        })
    }
}

function validarCURP(curp) {
    var re = /^([A-Z][AEIOUX][A-Z]{2}\d{2}(?:0\d|1[0-2])(?:[0-2]\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\d])(\d)$/
    var validado = curp.match(re)

    // Coincide con el formato general?
    if (!validado) { return false }

    // Validar que coincida el dígito verificador
    /* function digitoVerificador(curp17) {
        // Fuente https://consultas.curp.gob.mx/CurpSP/
        var diccionario = '0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZ'
        var lngSuma = 0.0
        var lngDigito = 0.0
        for (var i = 0; i < 17; i++) { lngSuma = lngSuma + diccionario.indexOf(curp17.charAt(i)) * (18 - i) }
        lngDigito = 10 - lngSuma % 10
        if (lngDigito == 10) { return 0 }
        return lngDigito
    }
    if (validado[2] != digitoVerificador(validado[1])) { return false }
*/
    return true // Validado
}

export default {
    getBase64,
    validarCURP,

}
