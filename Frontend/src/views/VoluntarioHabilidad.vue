<template>
    <b-container class="bv-example-row bv-example-row-flex-cols">
        <b-row style="text-align:center;margin-bottom:80px">
            <b-col align-self="center">
                <h1>Voluntarios</h1>
            </b-col>
        </b-row>
        <b-row style="text-align:center;">
            <b-col align-self="center">
                <b-form-input v-model="text" 
                placeholder="Ingrese una Habilidad para buscar los Voluntarios que correspondan"
                style="margin-bottom:35px;">
                </b-form-input>
                <b-button @click="getVoluntariosSegunHabilidad()">Buscar Voluntarios</b-button>
            </b-col>
        </b-row>
    </b-container>
</template>

<script>
    import axios from 'axios';
    export default {
        data() {
            return {
                text: '',
                datos: ''
            }
        },

        methods:{
        async getVoluntariosSegunHabilidad(){
            console.log("funciona")
            try {
                this.datos = await axios.get('ruta del back' + this.text)

            } 
            catch (error) {
                console.log(error)
            }
        }
    }
    }

</script>