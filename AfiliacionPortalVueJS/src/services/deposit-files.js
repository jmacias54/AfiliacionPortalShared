import requestSrv from './index'

function depositFiles(nombreArchivo, base64) {
    return new Promise((resolve, reject) => {
        requestSrv({
            path: 'middle/deposit-files/',
            method: 'POST',
            data: {
                FileContent: base64,
                FileName: nombreArchivo,
                Path: process.env.DEPOSIT_FILES_PATH,
                additionalData: [
                    {
                        name: 'ApplicationName',
                        value: 'IRN',
                    },
                    {
                        name: 'Environment',
                        value: 'Desarrollo',
                    },
                ],
                userId: 'JP997832',
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
    depositFiles,

}
