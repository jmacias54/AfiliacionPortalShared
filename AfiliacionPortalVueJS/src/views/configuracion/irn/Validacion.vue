<template>
  <div>
    <v-container>
      <v-container>
        <v-card class="mx-auto">
          <v-row>
            <v-col
              cols="6"
              lg="3"
            >
              <v-menu
                ref="menu1"
                v-model="menu1"
                :close-on-content-click="false"
                transition="scale-transition"
                offset-y
                max-width="290px"
                min-width="290px"
                class=".font-weight-regular"
              >
                <template v-slot:activator="{ on }">
                  <v-text-field
                    v-model="fechaInicioVigenciaFormatted"
                    label="Fecha inicio vigencia."
                    hint="DD/MM/AAAA"
                    persistent-hint
                    prepend-icon="mdi-calendar"
                    @blur="
                      fechaInicioVigencia = parseDate(
                        fechaInicioVigenciaFormatted
                      )
                    "
                    v-on="on"
                  />
                </template>
                <v-date-picker
                  v-model="fechaInicioVigencia"
                  no-title
                  locale="es-mx"
                  @input="menu1 = false"
                />
              </v-menu>
            </v-col>

            <v-col
              cols="6"
              lg="3"
            >
              <v-menu
                ref="menu1"
                v-model="menu2"
                :close-on-content-click="false"
                transition="scale-transition"
                offset-y
                max-width="290px"
                min-width="290px"
              >
                <template v-slot:activator="{ on }">
                  <v-text-field
                    v-model="fechaFinVigenciaFormatted"
                    label="Fecha fin vigencia."
                    hint="DD/MM/AAAA"
                    persistent-hint
                    prepend-icon="mdi-calendar"
                    @blur="
                      fechaFinVigencia = parseDate(fechaFinVigenciaFormatted)
                    "
                    v-on="on"
                  />
                </template>
                <v-date-picker
                  v-model="fechaFinVigencia"
                  no-title
                  locale="es-mx"
                  :min="fechaMin"
                  @input="menu2 = false"
                />
              </v-menu>
            </v-col>
          </v-row>
          <v-row>
            <v-col
              cols="12"
              lg="12"
            >
              <v-btn
                class="ma-2"
                :loading="cargando"
                :disabled="cargando"
                color="primary"
                @click="consultar"
              >
                Buscar
              </v-btn>

              <v-btn
                class="ma-2"
                color="secondary"
                @click="cancelar"
              >
                Cancelar
              </v-btn>

              <v-btn
                v-if="validarBtn"
                class="ma-2"
                color="accent"
                @click="validar"
              >
                Validar
              </v-btn>
            </v-col>
          </v-row>

          <v-container>
            <v-card class="mx-auto">
              <v-data-table
                locale="es-MX"
                :headers="headers"
                :items="desserts"
                :loading="cargando"
                class="elevation-1"
                :page.sync="pagina"
                :items-per-page="elementosPorPagina"
                hide-default-footer
                @page-count="paginaConteo = $event"
              />
              <div class="text-center pt-2">
                <v-pagination
                  v-model="pagina"
                  :length="paginaConteo"
                />
              </div>
            </v-card>
          </v-container>
        </v-card>
      </v-container>
    </v-container>
  </div>
</template>

<script>
  import irnReq from '@/services/configuracion/irn.js'

  export default {
    data: vm => ({
      archivo: {},
      pagina: 1,
      validarBtn: false,
      paginaConteo: 0,
      elementosPorPagina: 10,
      cargando: false,
      base64String: '',
      objRequest: {},
      fechaMin: new Date().toISOString().slice(0, 10),
      fechaInicioVigencia: new Date().toISOString().substr(0, 10),
      fechaInicioVigenciaFormatted: vm.formatDate(
        new Date().toISOString().substr(0, 10)
      ),
      fechaFinVigencia: new Date().toISOString().substr(0, 10),
      fechaFinVigenciaFormatted: vm.formatDate(
        new Date().toISOString().substr(0, 10)
      ),
      menu1: false,
      menu2: false,
      headers: [
        {
          text: 'Gpo. Trabajador Siefore',
          align: 'start',
          sortable: false,
          value: 'grupoTrabajadorSiefore',
        },
        { text: 'Clave Administradora', value: 'claveAdministradora' },
        { text: 'Comisiones', value: 'comisiones' },
        { text: 'Rendimiento (%)', value: 'porcentajeRendimiento' },
        { text: 'Rendimiento Real (%)', value: 'porcentajeRendimientoReal' },
        { text: 'Rendimiento Nominal (%)', value: 'porcentajeRendimientoNominal' },
      ],
      desserts: [],
    }),
    computed: {},
    watch: {

      fechaInicioVigencia (val) {
        this.fechaInicioVigenciaFormatted = this.formatDate(
          this.fechaInicioVigencia
        )
        var fechaMinima = new Date(this.fechaInicioVigencia)
        fechaMinima.setDate(fechaMinima.getDate() + 1)
        this.fechaMin = fechaMinima.toISOString().slice(0, 10)

        this.fechaFinVigenciaFormatted = this.formatDate(this.fechaMin)
      },
      fechaFinVigencia (val) {
        this.fechaFinVigenciaFormatted = this.formatDate(this.fechaFinVigencia)
      },
    },
    methods: {

      validar () {
        this.$swal({
          title: this.$decoder('Validar Informaci&oacute;n'),
          text: this.$decoder('Desea aplicar la validaci&oacute;n ?'),
          type: 'warning',
          showCancelButton: true,
          confirmButtonText: 'Si',
          cancelButtonText: 'No, Cancelar',
          showCloseButton: true,
          showLoaderOnConfirm: true,
        }).then((result) => {
          if (result.value) {
            this.actualizaIRN(this.fechaInicioVigenciaFormatted,
                              this.fechaFinVigenciaFormatted)
            this.cancelar()
            this.$swal('Validacion', this.$decoder('La validaci&oacute;n fue aplicada'), 'success')
          } else {
            this.$swal('Cancelado', this.$decoder('la validaci&oacute;n no se aplico'), 'info')
          }
        })
      },

      consultar () {

        this.consultarIrn(
          this.fechaInicioVigenciaFormatted,
          this.fechaFinVigenciaFormatted
        )
      },
      cancelar () {
        this.desserts = []
        this.validarBtn = false
      },

      formatDate (date) {
        if (!date) return null

        const [year, month, day] = date.split('-')
        return `${day}/${month}/${year}`
      },
      parseDate (date) {
        if (!date) return null

        const [day, month, year] = date.split('/')
        return `${year}-${month.padStart(2, '0')}-${day.padStart(2, '0')}`
      },

      consultarIrn (fechaInicioVigencia, fechaFinVigencia) {
        this.cargando = true

        irnReq
          .consultaIRN(fechaInicioVigencia, fechaFinVigencia)
          .then(response => {

            if (response != null) {
              if (response.data != null) {
                if (
                  response.data.registrosIRN != null &&
                  response.data.registrosIRN.length > 0
                ) {
                  this.desserts = response.data.registrosIRN
                  this.validarBtn = true
                }
              }
            }

            this.desserts = response.data.registrosIRN
            this.cargando = false
          })
          .catch(error => {
            this.cargando = false
            console.log(error)
            this.$swal('Oops', 'Something went wrong!', 'error')
          })
      },

      actualizaIRN (fechaInicioVigencia, fechaFinVigencia) {
        var inicioOperacion = 1

        irnReq
          .actualizaIRN(fechaInicioVigencia, fechaFinVigencia, inicioOperacion)
          .then(response => {
            if (response != null) {
              if (response.data != null) {
              }
            }
          })
          .catch(error => {
            console.log(error)
            this.$swal('Oops', 'Something went wrong!', 'error')
          })
      },
    },
  }
</script>

<style>
.bottom-padding {
  padding-bottom: 5%;
}
</style>
