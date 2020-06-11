import router from '../../router/index'
import authSrv from '../../services/auth'

const token = sessionStorage.getItem('token')
const initialState = token ? {
    status: { loggedIn: true },
    token,
} : {
        status: null,
        token: null,
    }

export default {
    namespaced: true,
    state: initialState,

    actions: {

        initAuth({ commit }) {
            console.log(' -- initAuth -- ')

            commit('logout')
        },

        login({ commit }, { usuario, contrasena }) {
            console.log(' -- login -- ')

            commit('loginRequest', { usuario })

            return authSrv.login({
                usuario,
                contrasena,
            })
                .then(response => {
                    sessionStorage.setItem('token', response.data.token)
                    sessionStorage.setItem('user', JSON.stringify(response.data.usuario))
                    commit('loginSuccess', response.data)
                    // eslint-disable-next-line handle-callback-err
                    router.push({ name: 'Home' }).catch(err => {
                        console.log('error perron en el push', err)
                    })
                })
                .catch((error) => {
                    commit('loginFailure', error)

                    throw error
                })
        },

        logout({ commit }) {
            console.log(' -- logout -- ')

            authSrv.logout()
            commit('logout')
        },

        refreshToken({ commit }, refreshToken) {
            sessionStorage.setItem('token', refreshToken)
            commit('loginSuccess', refreshToken)
        },
    },

    mutations: {
        loginRequest(state, currToken) {
            state.status = { loggingIn: true }
            state.token = currToken
        },
        loginSuccess(state, currToken) {
            state.status = { loggedIn: true }
            state.token = currToken
        },
        loginFailure(state, err) {
            state.status = err
            state.token = null
        },
        logout(state) {
            state.status = null
            state.token = null
        },
    },

    getters: {
        token: state => state.token,
        status: state => state.status,
    },
}
