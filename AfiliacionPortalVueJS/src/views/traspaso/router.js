import Traspaso from '@/views/traspaso/Traspaso.vue';
import CatalogosAdminApp from '@/views/traspaso/traspaso_pro/admin_app/Catalogos.vue'
import autenticacionInhabilitacion from '@/views/traspaso/traspaso_pro/autenticacion/Inhabilitacion.vue'

export default {
    path: 'traspaso',
    component: Traspaso,
    meta: {
        name: 'traspaso',
        breadcrumb: 'traspaso',
    },
    children: [
        {
            path: '/traspaso-pro/autenticacion/inhabilitacion',
            name: 'inhabilitacion-autenticacion-traspasos-pro',
            meta: {
                text: 'Inhabilitaci&oacute;n',
            },
            component: autenticacionInhabilitacion,

        },
        {
            path: '/traspaso-pro/admin-app/catalogos',
            name: 'catalogos-admin-app',
            meta: {
                text: 'Cat&aacute;logos Admin App',
            },
            component: CatalogosAdminApp,

        },
    ],
};
