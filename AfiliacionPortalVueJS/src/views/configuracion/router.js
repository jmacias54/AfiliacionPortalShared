import Configuracion from '@/views/configuracion/Configuracion.vue';
import CargaArchivoIRN from '@/views/configuracion/irn/CargaArchivo.vue'
import validacionIRN from '@/views/configuracion/irn/Validacion.vue'

export default {
    path: 'configuracion',
    component: Configuracion,
    meta: {
        name: 'configuracion',
        breadcrumb: 'configuracion',
    },
    children: [
        {
            path: '/configuracion/irn/carga-archivo',
            name: 'carga-archivo-irn',
            meta: {
                text: 'Carga Archivo IRN',
            },
            component: CargaArchivoIRN,

        },
        {
            path: '/configuracion/irn/validacion',
            name: 'validacion-irn',
            meta: {
                text: 'Validaci&oacute;n  IRN',
            },
            component: validacionIRN,

        },
    ],
};
