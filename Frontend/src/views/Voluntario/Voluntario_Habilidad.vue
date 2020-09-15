<template>
    <b-container class="bv-example-row bv-example-row-flex-cols">
        <b-row style="text-align:center;margin-bottom:2px">
            <b-col  align-self="center">
                <h1>Voluntario y Habilidad</h1>
            </b-col>
        </b-row>
        <br>
        <br>
        <table class="table" v-if="mostrar">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">id_Voluntario</th>
                    <th scope="col">id_Habilidad</th>
                </tr>
            </thead>
        </table>

    </b-container>
</template>

<script>
    import axios from 'axios';
    const localhost = 'http://localhost:8080/volHabilidad/';
    export default {
        data() {
            return {
                text: '',
                mostrar: false,
                items: []
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
            }
        },

        created() {
            this.mostrar = false;
            this.getVoluntarios();
            this.mostrar = true;
        }

}
</script>