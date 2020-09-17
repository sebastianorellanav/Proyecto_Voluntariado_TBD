<template>
    <b-container>
        <div style="margin-bottom:20px;margin-top:-25px">
            <h1>Añadir Nuevo Voluntario</h1>
        </div>
        <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group 
      id="input-group-1" 
      label="Nombre Voluntario:" 
      label-for="input-1">
        <b-form-input
          id="input-1"
          v-model="form.nombre"
          required
          placeholder="Ingrese un nombre "
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Fecha de Nacimiento:" label-for="input-2">
            <b-form-datepicker 
            id="input-2" 
            v-model="form.fnacimiento" 
            placeholder="Selecciona una fecha"
            local="en" 
            required>
            </b-form-datepicker>
            
      </b-form-group>
      <div style="padding-bottom:20px">
          <b-button type="submit" variant="success" size="lg" style="margin-right:20px">Crear</b-button>
      <b-button type="reset" variant="danger" size="lg" to="/voluntario" >Cancelar</b-button>
      </div>
    </b-form>
  </div>
  <br>
  <br>
  <br>
  <h3>{{respuesta}}</h3>
    </b-container>
</template>

<script>
  import axios from 'axios';
const url_post = 'http://localhost:8080/voluntario/create';
  export default {
    data() {
      return {
        form: {
          nombre: '',
          fnacimiento: '',
        },
        show: true,
        respuesta: ''
        
      }
    },
    methods: {
      async onSubmit() {
        //evt.preventDefault()
        //alert("¿Esta seguro que desea enviar el formulario?")
        const formData = new FormData();
        formData.append('nombre', this.form.nombre);
        formData.append('fnacimiento', this.form.fnacimiento);
        try {
          let res = await axios.post(url_post, formData);
         this.respuesta = res.data
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
        this.form.nombre = ''
        this.form.fnacimiento = ''
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      },
    },

  }
</script>