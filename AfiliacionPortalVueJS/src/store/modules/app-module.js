import { set, toggle } from '@/utils/vuex'

export default {
    namespaced: true,
    state: {
        drawer: null,
    },

    actions: {

    },

    mutations: {
        setDrawer: set('drawer'),
        toggleDrawer: toggle('drawer'),
    },

    getters: {
        drawer: state => state.drawer,
    },
}
