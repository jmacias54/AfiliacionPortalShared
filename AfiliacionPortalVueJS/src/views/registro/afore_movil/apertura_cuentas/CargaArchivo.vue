<template>
  <div>
    <v-container>
      <v-container>
        <v-card class="mx-auto">
          <v-row>
            <v-col
              cols="5"
              lg="5"
            >
              <v-file-input
                v-model="archivo"
                color="primary accent-4"
                counter
                label="Carga archivo."
                placeholder="Selecciona el archivo"
                prepend-icon="mdi-paperclip"
                outlined
                :show-size="1000"
                @change="onFileChange"
              >
                <template v-slot:selection="{ index, text }">
                  <v-chip
                    v-if="index < 2"
                    color="prof_txt_1 accent-4"
                    dark
                    label
                    small
                  >
                    {{ text }}
                  </v-chip>

                  <span
                    v-else-if="index === 2"
                    class="overline grey--text text--darken-3 mx-2"
                  >
                    +{{ archivo.length - 2 }} File(s)
                  </span>
                </template>
              </v-file-input>
            </v-col>
            <v-col
              cols="3"
              lg="4"
            >
              <v-btn
                class="ma-2"
                :loading="cargando"
                :disabled="cargando"
                color="primary"
                @click="validaCargaArchivo"
              >
                <v-icon>mdi-upload-outline</v-icon>
              </v-btn>
            </v-col>
          </v-row>
        </v-card>
      </v-container>|
    </v-container>
  </div>
</template>

<script>
  import aperturaCuentasRqt from '@/services/registro/afore-movil/apertura-cuentas/apertura-cuentas.js'
  import convierteBase64 from '@/services/utils.js'

  export default {
    data () {
      return {
        archivo: null,
        base64String: '',
        nombreArchivo: '',
        objRequest: {},
        cargando: false,
      }
    },
    methods: {
      cargarArchivo (nombreArchivo, base64) {
        console.log('nombreArchivo', nombreArchivo)
        console.log('base64', base64)

        aperturaCuentasRqt
          .cargaArchivo(nombreArchivo, base64)
          .then(response => {
            console.log(response)

            if (response != null) {
              if (response.data != null && response.data.success) {
                this.$swal(
                  'Carga archivo.',
                  'El archivo se guardo satisfactoriamente',
                  'success'
                )
                this.limpiar()
              }
            }

            this.cargando = false
          })
          .catch(error => {
            this.cargando = false
            console.log(error)
            this.$swal('Oops', 'Something went wrong!', 'error')
          })
      },

      async validaCargaArchivo () {
        this.cargando = true

        var nombreArchivo
        var base64

        if (this.archivo != null) {
          nombreArchivo = this.archivo.name
          var file = this.archivo
          base64 = await convierteBase64.getBase64(file)
          console.log('nombreArchivo', nombreArchivo)
          console.log('base64', base64)

          this.cargarArchivo(nombreArchivo, base64)
        } else {
          this.$swal(
            'No se ha seleccionado ningun archivo!',
            'Por favor seleccione archivo a cargar.',
            'info'
          )
          this.cargando = false
        }
      },

      limpiar () {
        this.archivo = null
        this.base64String = ''
        this.nombreArchivo = ''
        this.objRequest = {}
        this.cargando = false
      },
      onFileChange (event) {
        this.archivo = event
      },
    },
  }
</script>

<style>
.bottom-padding {
  padding-bottom: 5%;
}
</style>
