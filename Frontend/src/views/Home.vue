<template>
  <div id="msgBv">
    <img alt="Vue logo" src="../assets/logo.png">
    <Bienvenida msg="Bienvenido a la App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Bienvenida from '@/components/Bienvenida.vue'

export default {
  name: 'Home',
  components: {
    Bienvenida
  }
}
</script>

<style>
#msgBv {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
