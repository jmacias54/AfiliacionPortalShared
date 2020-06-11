import 'babel-polyfill'
import '@mdi/font/css/materialdesignicons.css'
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins'
import vuetify from './plugins/vuetify'
import { sync } from 'vuex-router-sync'
import VueSweetalert2 from 'vue-sweetalert2'
import 'sweetalert2/dist/sweetalert2.min.css'
import './styles/global.css'
import decoder from './plugins/decoder'
import VeeValidate from 'vee-validate'


Vue.use(VueSweetalert2)
Vue.use(decoder)
Vue.use(VeeValidate)


sync(store, router)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  created() {
    if (window.addEventListener && document.hidden) {
      window.addEventListener('storage', () => {
        sessionStorage.removeItem('token')
        sessionStorage.removeItem('user')
        this.$router.push('/')
      })
    }
  },
  render: h => h(App),
}).$mount('#app')
