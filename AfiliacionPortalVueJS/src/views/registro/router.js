import Registro from '@/views/registro/Registro.vue';
import CargaArchivoAperturaCuentas from '@/views/registro/afore_movil/apertura_cuentas/CargaArchivo.vue'
import ActualizaCodace from '@/views/registro/afore_movil/apertura_cuentas/ActualizaCodace.vue'

export default {
    path: 'registro',
    component: Registro,
    meta: {
        name: 'registro',
        breadcrumb: 'registro',
    },
    children: [
        {
            path: '/registro/afore-movil/apertura-cuentas/carga-archivo',
            name: 'carga-archivo-apertura-cuentas',
            meta: {
                text: 'Apertura de Cuentas - Carga archivo',
            },
            component: CargaArchivoAperturaCuentas,

        },
        {
            path: '/registro/afore-movil/apertura-cuentas/actualiza-codace',
            name: 'actualiza-codace',
            meta: {
                text: 'Actualiza CODACE',
            },
            component: ActualizaCodace,

        },
    ],
};
