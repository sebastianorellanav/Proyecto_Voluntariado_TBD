<template>
  <div>
    <b-button v-b-modal.modal-prevent-closing>Editar</b-button>
    <b-modal
      id="modal-prevent-closing"
      title="Submit Your Name"
      @show="resetModal"
      @hidden="resetModal"
      @ok="handleOk"
    >
    <form @submit.stop.prevent="handleSubmit">
        <b-form-group 
            id="input-group-1" 
            label="Nombre Voluntario:" 
            label-for="input-1">
        <b-form-input
          id="input-1"
          v-model="form.nombre"
          required
          :placeholder= voluntarioAEditar.nombre
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
      </form>
    </b-modal>
  </div>
</template>

<script>
const url_post = 'http://localhost:8080/voluntario/update';
const localhost = 'http://localhost:8080/voluntario/';
import axios from 'axios';
  export default {
    name: 'ModalEditarVoluntario',
       data: () => ({
        name: '',
        nameState: null,
        form: {
          nombre: '',
          fnacimiento: '',
        },
        voluntarioAEditar: {
            nombre: ''
        }
    }),
    props: [
        "idVoluntario",
    ],
    methods: {
        async getVoluntarioEspecifico(){
                var url = localhost;
                try {
                    axios.get(url + this.idVoluntario).then((response) => {
                        this.voluntarioAEditar = response.data;
                    });
                    console.log(this.voluntarioAEditar)
                } 
                catch (error) {
                    console.log(error)
                }
            },
      resetModal() {
        this.getVoluntarioEspecifico();
      },
      async handleOk(bvModalEvt) {
        
        const formData = new FormData();
        formData.append('id', this.idVoluntario.toString());
        formData.append('nombre', this.form.nombre);
        formData.append('fnacimiento', this.form.fnacimiento);
        try {
          let res = await axios.post(url_post, formData);
         console.log(res.data);
        } 
        catch (error) {
            console.log(error)
          }
        // Prevent modal from closing
        bvModalEvt.preventDefault()
        // Trigger submit handler
        this.handleSubmit()
      },
      handleSubmit() {
        // Hide the modal manually
        this.$nextTick(() => {
          this.$bvModal.hide('modal-prevent-closing')
        })
      }
    }
  }
</script>