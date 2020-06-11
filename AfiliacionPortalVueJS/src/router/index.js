
import Vue from 'vue'
import Router from 'vue-router'
import Login from '../views/Login.vue'
import Admin from '../components/core/Admin.vue'

import Home from '../views/Home.vue'

/* R O U T E S */
import configuracionRouter from '@/views/configuracion/router'
import registroRouter from '@/views/registro/router'
import traspasoRouter from '@/views/traspaso/router'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.NODE_ENV === 'production' ? '/AfiliacionPortal/' : '/',

  scrollBehavior() {
    return { x: 0, y: 0 }
  },

  routes: [
    {
      path: '/',
      name: 'login',
      breadcrumb: 'login',
      meta: { title: 'login' },
      component: Login,
    },
    {
      path: '/admin',
      component: Admin,
      text: 'Admin',
      meta: {
        requiresAuth: true,
      },
      children: [
        {
          path: '/Home',
          name: 'Home',
          component: Home,
          meta: {
            text: 'Home',
          },

        },
        { ...traspasoRouter },
        { ...configuracionRouter },
        { ...registroRouter },

      ],
    },
    {
      path: '*',
      redirect: '/',
    },
  ],
})

router.beforeEach((to, from, next) => {
  const user = JSON.parse(sessionStorage.getItem('user'))
  document.querySelector('body').classList.remove('full-page')

  // document.title = to.meta.title

  if (to.matched.some(route => route.meta.requiresAuth)) {
    if (sessionStorage.getItem('token') === null) {
      document.title = 'login'
      next({ name: 'login' })
    } else {
      const activeRoles = []

      to.matched.forEach((route) => {
        if (route.meta.roles) {
          activeRoles.push(...route.meta.roles)
        }
      })

      if (to.meta.roles && to.meta.roles.length > 0) {
        if (activeRoles.includes(user.idRole)) {
          next()
        } else {
          if (to.name !== 'Home') { //eslint-disable-line
            next({ name: 'Home' })
          }
        }
      } else {
        if (user.idRole === 'ROLE_MKT_EDITOR') {
          next({ name: 'content-manager' })
        } else if (user.idRole === 'ROLE_COM_METVIEW') {
          next({ name: 'metrics-list' })
        } else {
          next()
        }

        return
      }
    }

    if (to.name === 'admin' || to.name === 'login') {
      next({ name: 'Home' })
    }
  } else {
    next()
  }

  if (sessionStorage.getItem('token') !== null && to.name === 'login') {
    next({ name: 'Home' })
  }
})

export default router
