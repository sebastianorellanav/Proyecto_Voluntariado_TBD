<template>
    <b-container class="bv-example-row bv-example-row-flex-cols">
        <b-row style="text-align:center;margin-bottom:80px">
            <b-col align-self="center">
                <h1>Voluntarios</h1>
                <h6>Según Emergencia</h6>
            </b-col>
        </b-row>
        <b-row style="text-align:center;">
            <b-col align-self="center">
                <b-form-input v-model="text" 
                placeholder="Ingrese una Emergencia para buscar los Voluntarios que correspondan"
                style="margin-bottom:35px;">
                </b-form-input>
                <b-button @click="getVoluntariosSegunEmergencia()">Buscar Voluntarios</b-button>
            </b-col>
        </b-row>

        <br>
        <br>
        <br>
        <table class="table" v-if="mostrar">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Fecha nacimiento</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(item, index) in items" :key="index">
                    <th scope="row">{{item.id}}</th>
                    <td>{{item.nombre}}</td>
                    <td>{{item.fnacimiento}}</td>
                </tr>
            </tbody>
        </table>

    </b-container>
</template>

<script>
    import axios from 'axios';
    const localhost = 'http://localhost:8080/voluntarios/emergencia/';
    export default {
        data() {
            return {
                text: '',
                mostrar: false,
                items: []
            }
        },

        methods:{
        async getVoluntariosSegunEmergencia(){
            this.mostrar = true;
            var url = localhost + this.text;
            console.log("funciona")
            try {
                axios.get(url).then((response) => {
                    this.items = response.data;
                });
                console.log(this.items)
            } 
            catch (error) {
                console.log(error)
            }
        }
    }
    }
</script>