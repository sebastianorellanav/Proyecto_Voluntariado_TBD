import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  
  {
    path: '/voluntarios/habilidad',
    name: 'VoluntarioHabilidad',
    component: () => import(/* webpackChunkName: "about" */ '../views/VoluntarioHabilidad.vue')
  },

  {
    path: '/voluntarios/emergencia',
    name: 'VoluntarioEmergencia',
    component: () => import(/* webpackChunkName: "about" */ '../views/VoluntarioEmergencia.vue')
  },

  {
    path: '/emergencia',
    name: 'Emergencias',
    component: () => import(/* webpackChunkName: "about" */ '../views/Emergencias.vue')
  },

  {
    path: '/emergencia/nueva',
    name: 'AñadirEmergencia',
    component: () => import(/* webpackChunkName: "about" */ '../views/AñadirEmergencia.vue')
  },

  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
