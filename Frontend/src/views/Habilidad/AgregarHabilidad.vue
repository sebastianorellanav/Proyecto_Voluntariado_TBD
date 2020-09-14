<template>
    <b-container>
        <div style="margin-bottom:20px;margin-top:-25px">
            <h1>Añadir Nueva Habilidad</h1>
        </div>
        <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">

      <b-form-group 
      id="input-group-1" 
      label="Descripción:" 
      label-for="input-1">
        <b-form-textarea
        id="input-1"
        v-model="form.descripcion"
        placeholder="Ingrese una descripción de la habilidad..."
        rows="3"
        max-rows="6"
        ></b-form-textarea>
      </b-form-group>

      <div style="padding-bottom:20px">
          <b-button type="submit" variant="success" size="lg" style="margin-right:20px" @click="onSubmit()">Crear</b-button>
      <b-button type="reset" variant="danger" size="lg" to="/habilidad" >Cancelar</b-button>
      </div>
    </b-form>
  </div>
    </b-container>
</template>

<script>
  import axios from 'axios';
const url_post = 'http://localhost:8080/habilidad/create';
  export default {
    data() {
      return {
        form: {
          descripcion: '',
        },
        show: true,
        
      }
    },
    methods: {
      async onSubmit() {
        //evt.preventDefault()
        //alert("¿Esta seguro que desea enviar el formulario?")
        const formData = new FormData();
        formData.append('descripcion', this.form.descripcion);
        try {
          let res = await axios.post(url_post, formData);
         console.log(res.data);
        } 
        catch (error) {
            console.log(error)
          }
        this.onReset()
      },
      onReset() {
        //evt.preventDefault()
        // Reset our form values
        this.form.descripcion = ''
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      },
    },
  }
</script>