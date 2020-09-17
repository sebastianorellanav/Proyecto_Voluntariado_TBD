<template>
    <b-container class="bv-example-row bv-example-row-flex-cols">
        <b-row style="text-align:center;margin-bottom:2px">
            <b-col  align-self="center">
                <h1>Voluntarios</h1>
            </b-col>
        </b-row>
        <b-button variant="success" to="/voluntario/nuevo">Nuevo Voluntario</b-button>
        <br>
        <br>
        
        <table class="table" v-if="mostrar">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Fecha Nacimiento</th>
                    <th scope="col">Editar</th>
                    <th scope="col">Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(item, index) in items" :key="index">
                    <th scope="row">{{item.id}}</th>
                    <td>{{item.nombre}}</td>
                    <td>{{item.fnacimiento}}</td>
                    <td><b-button variant="primary">Editar</b-button></td>
                    <td><b-button variant="danger" @click="eliminarRegistro(item.id)">Eliminar</b-button></td>
                </tr>
            </tbody>
        </table>

    </b-container>
</template>

<script>
    import axios from 'axios';
    const localhost = 'http://localhost:8080/voluntario/';
    const url_eliminar = 'http://localhost:8080/voluntario/delete/';
    export default {
        data() {
            return {
                text: '',
                mostrar: false,
                items: [],
                voluntarioAEditar: {},
                mostrarVentanaEdicion: false,
            }
        },
        methods:{
            async getVoluntarios(){
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
                //const formData = new FormData();
                //formData.append('id', id);
                try {
                let res = await axios.get(url_eliminar + id);
                console.log(res.data);
                } 
                catch (error) {
                    console.log(error)
                }
                this.recargarVoluntarios()
            },

            recargarVoluntarios(){
                this.mostrar = false;
                this.getVoluntarios();
                this.mostrar = true;
            }
        },

        created() {
            this.mostrar = false;
            this.getVoluntarios();
            this.mostrar = true;
        }

}
</script>