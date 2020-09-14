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
    component: () => import(/* webpackChunkName: "about" */ '../views/Voluntario/Voluntario_Habilidad.vue')
  },
  
  {
    path: '/voluntarios/habilidad',
    name: 'VoluntarioHabilidad',
    component: () => import(/* webpackChunkName: "about" */ '../views/Voluntario/VoluntarioHabilidad.vue')
  },

  {
    path: '/voluntarios/emergencia',
    name: 'VoluntarioEmergencia',
    component: () => import(/* webpackChunkName: "about" */ '../views/Voluntario/VoluntarioEmergencia.vue')
  },

  {
    path: '/emergencia',
    name: 'Emergencias',
    component: () => import(/* webpackChunkName: "about" */ '../views/Emergencia/Emergencias.vue')
  },

  {
    path: '/emergencia/nueva',
    name: 'AñadirEmergencia',
    component: () => import(/* webpackChunkName: "about" */ '../views/Emergencia/AñadirEmergencia.vue')
  },
  {
    path: '/voluntario',
    name: 'Voluntario',
    component: () => import(/* webpackChunkName: "about" */ '../views/Voluntario/Voluntarios.vue')
  },
  {
    path: '/voluntario/nuevo',
    name: 'AgregarVoluntario',
    component: () => import(/* webpackChunkName: "about" */ '../views/Voluntario/AgregarVoluntario.vue')
  },

  {
    path: '/habilidad',
    name: 'Habilidades',
    component: () => import(/* webpackChunkName: "about" */ '../views/Habilidad/Habilidades.vue')
  },
  {
    path: '/habilidad/nueva',
    name: 'AgregarHabilidad',
    component: () => import(/* webpackChunkName: "about" */ '../views/Habilidad/AgregarHabilidad.vue')
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
