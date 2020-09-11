<template>
    <b-container class="bv-example-row bv-example-row-flex-cols">
        <b-row style="text-align:center;margin-bottom:2px">
            <b-col  align-self="center">
                <h1>Emergencias</h1>
            </b-col>
        </b-row>
        <b-button variant="success" to="/emergencia/nueva">Nueva Emergencia</b-button>
        <br>
        <br>
        <table class="table" v-if="mostrar">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Descripción</th>
                    <th scope="col">Fecha Inicio</th>
                    <th scope="col">Fecha Fin</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(item, index) in items" :key="index">
                    <th scope="row">{{item.id}}</th>
                    <td>{{item.nombre}}</td>
                    <td>{{item.descrip}}</td>
                    <td>{{item.finicio}}</td>
                    <td>{{item.ffin}}</td>
                </tr>
            </tbody>
        </table>

    </b-container>
</template>

<script>
    import axios from 'axios';
    const localhost = 'http://localhost:8080/emergencia/';
    export default {
        data() {
            return {
                text: '',
                mostrar: false,
                items: []
            }
        },

        methods:{
            async getHistorial(){
                this.mostrar = true;
                var url = localhost;
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
        },

        created() {
            this.mostrar = false;
            this.getEmergencias();
            this.mostrar = true;
        }

}
</script>