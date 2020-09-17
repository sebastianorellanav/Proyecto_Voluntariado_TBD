<template>
    <b-container class="bv-example-row bv-example-row-flex-cols">
        <b-row style="text-align:center;margin-bottom:2px">
            <b-col  align-self="center">
                <h1>Habilidades</h1>
            </b-col>
        </b-row>
        <b-button variant="success" to="/habilidad/nueva">Nueva Habilidad</b-button>
        <br>
        <br>
        <table class="table" v-if="mostrar">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Editar</th>
                    <th scope="col">Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(item, index) in items" :key="index">
                    <th scope="row">{{item.id}}</th>
                    <td>{{item.descrip}}</td>
                    <td><b-button href="/habilidad/editar" variant="primary">Editar</b-button></td>
                    <td><b-button variant="danger" @click="eliminarRegistro(item.id)">Eliminar</b-button></td>
                </tr>
            </tbody>
        </table>

    </b-container>
</template>

<script>
    import axios from 'axios';
    const localhost = 'http://localhost:8080/habilidad/';
    const url_eliminar = 'http://localhost:8080/habilidad/delete/';
    export default {
        data() {
            return {
                text: '',
                mostrar: false,
                items: []
            }
        },

        methods:{
            async getHabilidades(){
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
            },
            
            async eliminarRegistro(id){
                try {
                let res = await axios.get(url_eliminar + id);
                console.log(res.data);
                } 
                catch (error) {
                    console.log(error)
                }
                this.recargarHabilidades()
            },

            recargarHabilidades(){
                this.mostrar = false;
                this.getHabilidades();
                this.mostrar = true;
            }
        },

        created() {
            this.mostrar = false;
            this.getHabilidades();
            this.mostrar = true;
        }

}
</script>