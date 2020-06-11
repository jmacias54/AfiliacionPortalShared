<template>
  <div>
    <v-container>
      <v-container>
        <v-card class="mx-auto">
          <v-form
            ref="form"
            v-model="valid"
            lazy-validation
          >
            <v-col
              cols="12"
              sm="10"
              md="8"
              lg="6"
            >
              <v-text-field
                v-model="curp"
                label="CURP"
                outlined
                :rules="curp_rules"
                required
              />

              <v-text-field
                v-model="resultadoCodace"
                label="Resultado CODACE"
                outlined
                :rules="resultado_codace_rules"
                required
              />

              <v-btn
                color="primary"
                class="mr-4"
                :loading="dialog"
                :disabled="dialog"
                @click="actualizarCODACE"
              >
                Actualizar
              </v-btn>

              <v-btn
                color="secondary"
                class="mr-4"
                :disabled="dialog"
                @click="limpiar"
              >
                Cancelar
              </v-btn>
            </v-col>
          </v-form>
        </v-card>
        <v-dialog
          v-model="dialog"
          persistent
          width="300"
        >
          <v-card
            color="primary"
            dark
          >
            <v-card-text>
              Por favor espere
              <v-progress-linear
                indeterminate
                color="white"
                class="mb-0"
              />
            </v-card-text>
          </v-card>
        </v-dialog>
      </v-container>
    </v-container>
  </div>
</template>

<script>
  import aperturaCuentasRqt from '@/services/registro/afore-movil/apertura-cuentas/apertura-cuentas.js'
  import utils from '@/services/utils.js'

  export default {
    data () {
      return {
        valid: true,
        curp: '',
        resultadoCodace: '',
        loading: false,
        dialog: false,

        curp_rules: [
          v => !!v || 'el campo CURP es requerido.',
          v => (v && this.validarCURP(v)) || 'Formato CURP invalido.',
        ],
        resultado_codace_rules: [
          v => !!v || 'el campo Resultado CODACE es requerido.',
          v =>
            (v && v.length == 2) ||
            'El campo Resultado CODACE debe tener 2 caracteres',
          v => /^\d+$/.test(v) || 'El campo Resultado CODACE debe tener numeros',
        ],
      }
    },
    methods: {
      actualizaCodace (curp, resultadoCodace) {
        console.log('curp', curp)
        console.log('resultadoCodace', resultadoCodace)
        this.dialog = true

        aperturaCuentasRqt
          .actualizaCodace(curp, resultadoCodace)
          .then(response => {
            console.log(response)

            if (response != null) {
              if (response.data != null && response.data.success) {
                this.$swal(
                  this.$decoder('Actualizaci&oacute;n.'),
                  response.data.message,
                  'success'
                )
              } else {
                this.$swal(
                  this.$decoder('Actualizaci&oacute;n.'),
                  this.$decoder('Error en la actualizaci&oacute;n '),
                  'error'
                )
                this.limpiar()
              }
            }

            this.dialog = false
            this.limpiar()
          })
          .catch(error => {
            this.loading = false
            console.log(error)
            this.$swal(
              this.$decoder('Actualizaci&oacute;n.'),
              this.$decoder('Error en la actualizaci&oacute;n '),
              'error'
            )
            this.limpiar()
          })
      },

      validarCURP (curp) {
        return utils.validarCURP(curp)
      },

      async actualizarCODACE () {
        if (this.$refs.form.validate()) {
          await this.actualizaCodace(this.curp, this.resultadoCodace)
        }
      },

      limpiar () {
        this.dialog = false
        this.$refs.form.reset()
      },
    },
  }
</script>

<style>
.bottom-padding {
  padding-bottom: 5%;
}
</style>
