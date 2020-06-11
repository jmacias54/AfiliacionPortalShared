/**
 * Vuex
 *
 * @library
 *
 * https://vuex.vuejs.org/en/
 */

// Lib imports
import Vue from 'vue'
import Vuex from 'vuex'

// Store functionality
/*import actions from './actions'
import getters from './getters'
import modules from './modules'
import mutations from './mutations'
import state from './state'
*/

import app from './modules/app-module'
import auth from './modules/auth-module'


Vue.use(Vuex)

// Create a new store
const store = new Vuex.Store({
  modules: {
    app: app,
    auth: auth,
  },
  state: {
  },
  mutations: {

  },
  getters: {

  },
  actions: {

  }
})

export default store
