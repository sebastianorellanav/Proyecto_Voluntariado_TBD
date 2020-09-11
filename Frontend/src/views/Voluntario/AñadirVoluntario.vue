<template>
    <b-container>
        <div style="margin-bottom:20px;margin-top:-25px">
            <h1>Añadir Nuevo Voluntario</h1>
        </div>
        <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group 
      id="input-group-1" 
      label="Nombre Emergencia:" 
      label-for="input-1">
        <b-form-input
          id="input-1"
          v-model="form.nombre"
          required
          placeholder="Ingrese un nombre. Ej: 'Terremoto en Arica' "
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Institucion:" label-for="input-2">
        <b-form-select
          id="input-2"
          v-model="form.idInstitucion"
          :options="instituciones"
          required
        ></b-form-select>
      </b-form-group>

        <b-form-group id="input-group-3" label="Fecha de Inicio:" label-for="input-3">
            <b-form-datepicker 
            id="input-3" 
            v-model="form.finicio" 
            locale="en" 
            required>
            </b-form-datepicker>
            
      </b-form-group>
      <b-form-group id="input-group-4" label="Fecha de Fin:" label-for="input-4">
            <b-form-datepicker 
            id="input-4" 
            v-model="form.ffin" 
            locale="en" 
            required>
            </b-form-datepicker>
            
      </b-form-group>

      <b-form-group 
      id="input-group-5" 
      label="Descripción:" 
      label-for="input-5">
        <b-form-textarea
        id="input-5"
        v-model="form.descripcion"
        placeholder="Ingrese una descripción de la emergencia..."
        rows="3"
        max-rows="6"
        ></b-form-textarea>
      </b-form-group>

      <div style="padding-bottom:20px">
          <b-button type="submit" variant="success" size="lg" style="margin-right:20px">Submit</b-button>
      <b-button type="reset" variant="danger" size="lg" to="/emergencia" @click="onSubmit()">Reset</b-button>
      </div>
    </b-form>
  </div>
    </b-container>
</template>

<script>
  import axios from 'axios';
const url_get = 'http://localhost:8080/institucion/form/';
const url_post = 'http://localhost:8080/emergencia/create';
  export default {
    data() {
      return {
        form: {
          nombre: '',
          descripcion: '',
          finicio: '',
          ffin: '',
          idInstitucion: null
        },
            instituciones: [
                { value: null, text: 'Please select an option' },
                { value: 'a', text: 'This is First option' },
                { value: 'b', text: 'Selected Option' },
                { value: { C: '3PO' }, text: 'This is an option with object value' },
                { value: 'd', text: 'This one is disabled', disabled: true }
        ],
        show: true,
        
      }
    },
    methods: {
      async onSubmit() {
        //evt.preventDefault()
        //alert("¿Esta seguro que desea enviar el formulario?")
        const formData = new FormData();
        formData.append('nombre', this.form.nombre);
        formData.append('descripcion', this.form.descripcion);
        formData.append('finicio', this.form.finicio);
        formData.append('ffin', this.form.ffin);
        formData.append('idInstitucion', this.form.idInstitucion);
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
        this.form.nombre = ''
        this.form.finicio = ''
        this.form.ffin = ''
        this.form.descripcion = ''
        this.idInstitucion = null
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      },
      async getInstituciones(){
                var url = url_get;
                console.log("funciona")
                try {
                    axios.get(url).then((response) => {
                        this.instituciones = response.data;
                    });
                    console.log(this.items)
                } 
                catch (error) {
                    console.log(error)
                }
            },
    },

    created(){
        this.getInstituciones();
    }
  }
</script>