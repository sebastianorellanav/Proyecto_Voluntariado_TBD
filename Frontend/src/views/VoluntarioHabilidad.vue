<template>
    <b-container class="bv-example-row bv-example-row-flex-cols">
        <b-row style="text-align:center;margin-bottom:80px">
            <b-col align-self="center">
                <h1>Voluntarios</h1>
            </b-col>
        </b-row>
        <b-row style="text-align:center;">
            <b-col align-self="center">
                <b-form-input v-model="text" placeholder="Ingrese una Habilidad para buscar los Voluntarios que correspondan"></b-form-input>
            </b-col>
        </b-row>
    </b-container>
</template>

<script>
  export default {
    data() {
      return {
        text: ''
      }
    }
  }
</script>