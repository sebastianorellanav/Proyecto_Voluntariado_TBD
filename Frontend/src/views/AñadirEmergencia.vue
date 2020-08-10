<template>
    <b-container>
        <div style="margin-bottom:20px;margin-top:-25px">
            <h1>Añadir Nueva Emergencia</h1>
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

        <b-form-group id="input-group-2" label="Fecha de Inicio:" label-for="input-2">
            <b-form-datepicker 
            id="input-2" 
            v-model="form.finici" 
            locale="en" 
            required>
            </b-form-datepicker>
            
      </b-form-group>

      <b-form-group id="input-group-3" label="Fecha de Fin:" label-for="input-3">
            <b-form-datepicker 
            id="input-3" 
            v-model="form.ffin" 
            locale="en" 
            required>
            </b-form-datepicker>
            
      </b-form-group>

      <b-form-group 
      id="input-group-4" 
      label="Descripción:" 
      label-for="input-2">
        <b-form-textarea
        id="input-4"
        v-model="form.descripcion"
        placeholder="Ingrese una descripción de la emergencia..."
        rows="3"
        max-rows="6"
        ></b-form-textarea>
      </b-form-group>

      <div style="padding-bottom:20px">
          <b-button type="submit" variant="success" size="lg" style="margin-right:20px">Submit</b-button>
      <b-button type="reset" variant="danger" size="lg" to="/emergencia">Reset</b-button>
      </div>
    </b-form>
  </div>
    </b-container>
</template>

<script>
  export default {
    data() {
      return {
        form: {
          nombre: '',
          descripcion: '',
          finicio: '',
          ffin: ''
        },
        foods: [{ text: 'Select One', value: null }, 'Carrots', 'Beans', 'Tomatoes', 'Corn'],
        show: true
      }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        alert(JSON.stringify(this.form))
      },
      onReset(evt) {
        evt.preventDefault()
        // Reset our form values
        this.form.nombre = ''
        this.form.finicio = ''
        this.form.ffin = ''
        this.form.descripcion = ''
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
    }
  }
</script>