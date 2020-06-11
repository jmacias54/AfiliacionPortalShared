<template>
  <div>
    <v-navigation-drawer
      id="app-drawer"
      v-model="inputValue"
      :mini-variant.sync="mini"
      light
      app
      floating
      mobile-break-point="991"
      persistent
    >
      <template v-slot:img="attrs">
        <v-img
          v-bind="attrs"
          gradient="to top, rgba(0, 0, 0, .7), rgba(0, 0, 0, .7)"
        />
      </template>

      <v-list-item two-line>
        <v-list-item-avatar color="white">
          <v-img
            src="../../assets/prof-ico.png"
            height="34"
            contain
            @click.stop="mini = !mini"
          />
        </v-list-item-avatar>

        <v-list-item-title class="title">
          <v-img
            src="../../assets/profuturo.png"
            height="34"
            alt="Profuturo"
            @click.stop="mini = !mini"
          />
        </v-list-item-title>
      </v-list-item>

      <v-list-item two-line>
        <v-list-item-avatar
          color="primary"
          size="36"
          :alt="iniciales"
          @click.stop="mini = !mini"
        >
          <span class="white--text headline">{{ iniciales }}</span>
        </v-list-item-avatar>
        <v-list-item-title
          color="prof_txt_6"
          size="36"
          @click.stop="mini = !mini"
        >
          {{ nombre }}
        </v-list-item-title>
      </v-list-item>

      <v-divider class="mx-3 mb-3" />

      <template>
        <v-list>
          <v-list-group value="true">
            <template v-slot:activator>
              <v-list-item-icon>
                <v-icon>mdi-transfer</v-icon>
              </v-list-item-icon>
              <v-list-item-title>Traspaso</v-list-item-title>
            </template>

            <v-list-group
              no-action
              sub-group
            >
              <template v-slot:activator>
                <v-list-item-content>
                  <v-list-item-title>Produce traspaso</v-list-item-title>
                </v-list-item-content>
              </template>

              <v-list-item>
                <v-list-item-title>Sub-menu</v-list-item-title>
              </v-list-item>
            </v-list-group>

            <v-list-group
              no-action
              sub-group
            >
              <template v-slot:activator>
                <v-list-item-content>
                  <v-list-item-title>Traspasos pro</v-list-item-title>
                </v-list-item-content>
              </template>

              <v-list-group
                no-action
                sub-group
              >
                <template v-slot:activator>
                  <v-list-item-content>
                    <v-list-item-title>
                      {{ txt.autenticacion }}
                    </v-list-item-title>
                  </v-list-item-content>
                </template>
                <v-list-item to="/traspaso-pro/autenticacion/inhabilitacion">
                  <v-list-item-title>
                    <v-icon color="prof_txt_1">
                      mdi-account-off-outline
                    </v-icon>
                    {{ txt.inhabilitacion }}
                  </v-list-item-title>
                </v-list-item>
              </v-list-group>

              <v-list-group
                no-action
                sub-group
              >
                <template v-slot:activator>
                  <v-list-item-content>
                    <v-list-item-title>
                      Admin App
                    </v-list-item-title>
                  </v-list-item-content>
                </template>
                <v-list-item to="/traspaso-pro/admin-app/catalogos">
                  <v-list-item-title>
                    <v-icon color="prof_txt_1">
                      mdi-file-table-box-multiple-outline
                    </v-icon>
                    {{ txt.catalogos }}
                  </v-list-item-title>
                </v-list-item>
              </v-list-group>
            </v-list-group>
          </v-list-group>

          <v-divider class="mx-3 mb-3" />

          <v-list-group>
            <template v-slot:activator>
              <v-list-item-icon>
                <v-icon> mdi-file-document-edit-outline </v-icon>
              </v-list-item-icon>
              <v-list-item-title>Registro</v-list-item-title>
            </template>
            <v-list-group
              no-action
              sub-group
            >
              <template v-slot:activator>
                <v-list-item-content>
                  <v-list-item-title>Afore Movil</v-list-item-title>
                </v-list-item-content>
              </template>

              <v-list-group
                no-action
                sub-group
              >
                <template v-slot:activator>
                  <v-list-item-content>
                    <v-list-item-title>Apertura de Cuentas</v-list-item-title>
                  </v-list-item-content>
                </template>

                <v-list-item
                  to="/registro/afore-movil/apertura-cuentas/carga-archivo"
                >
                  <v-list-item-title>
                    <v-icon color="prof_txt_1">
                      mdi-file-upload-outline
                    </v-icon>
                    Carga archivo
                  </v-list-item-title>
                </v-list-item>
                <v-list-item
                  to="/registro/afore-movil/apertura-cuentas/actualiza-codace"
                >
                  <v-list-item-title>
                    <v-icon color="prof_txt_1">
                      mdi-rotate-3d-variant
                    </v-icon>
                    Actualiza CODACE
                  </v-list-item-title>
                </v-list-item>
              </v-list-group>
            </v-list-group>
          </v-list-group>

          <v-divider class="mx-3 mb-3" />

          <v-list-group>
            <template v-slot:activator>
              <v-list-item-icon>
                <v-icon>mdi-cog-outline</v-icon>
              </v-list-item-icon>
              <v-list-item-title>{{ txt.configuracion }}</v-list-item-title>
            </template>

            <v-list-group
              no-action
              sub-group
              value="false"
            >
              <template v-slot:activator>
                <v-list-item-content>
                  <v-list-item-title>IRN</v-list-item-title>
                </v-list-item-content>
              </template>

              <v-list-item to="/configuracion/irn/validacion">
                <v-list-item-title>
                  <v-icon color="prof_txt_1">
                    mdi-file-find-outline
                  </v-icon>
                  {{ txt.validacion }}
                </v-list-item-title>
              </v-list-item>
              <v-list-item to="/configuracion/irn/carga-archivo">
                <v-list-item-title>
                  <v-icon color="prof_txt_1">
                    mdi-file-upload-outline
                  </v-icon>
                  Carga archivo
                </v-list-item-title>
              </v-list-item>
            </v-list-group>
          </v-list-group>
          <v-divider class="mx-3 mb-3" />
        </v-list>
      </template>

      <v-list-item @click="logout">
        <v-list-item-icon>
          <v-icon color="prof_txt_6">
            mdi-exit-to-app
          </v-icon>
        </v-list-item-icon>
        <v-list-item-title color="prof_txt_6">
          {{ txt.cerrar_sesion }}
        </v-list-item-title>
      </v-list-item>
    </v-navigation-drawer>
  </div>
</template>
<script>
  export default {
    props: {
      opened: {
        type: Boolean,
        default: false,
      },
    },
    data () {
      return {
        mini: true,
        links: [],
        usuario: {},
        iniciales: '',
        nombre: '',
        txt: {
          configuracion: this.$decoder('Configuraci&oacute;n'),
          validacion: this.$decoder('Validaci&oacute;n'),
          inhabilitacion: this.$decoder('inhabilitaci&oacute;n'),
          autenticacion: this.$decoder('Autenticaci&oacute;n'),
          cerrar_sesion: this.$decoder('Cerrar sesi&oacute;n'),
          catalogos: this.$decoder('Cat&aacute;logos'),
        },
      }
    },
    computed: {
      // ...mapState('app', ['image', 'color']),
      inputValue: {
        get () {
          console.log('get inputValue :', this.$store.state.app.drawer)
          return this.$store.state.app.drawer
        },
        set (val) {
          console.log('set inputValue :', val)
          this.$store.commit('app/setDrawer', val)
        // this.setDrawer(val)
        },
      },
    },
    created () {
      // this.currentRoute = this.$route.matched[1].meta.name || this.$route.name
      this.usuario = JSON.parse(sessionStorage.getItem('user'))
      this.iniciales =
        this.usuario.nombre.charAt(0) + this.usuario.apellidoPaterno.charAt(0)
      this.nombre =
        this.usuario.nombre +
        ' ' +
        this.usuario.apellidoPaterno +
        ' ' +
        this.usuario.apellidoMaterno
    },

    methods: {
      // ...mapMutations('app', ['setDrawer', 'toggleDrawer']),

      logout () {
        this.$swal({
          title: this.$decoder('Cerrar Sesi&oacute;n'),
          text: this.$decoder('Desea salir de la aplicaci&oacute;n ?'),
          type: 'warning',
          showCancelButton: true,
          confirmButtonText: 'Si',
          cancelButtonText: 'No',
          showCloseButton: true,
          showLoaderOnConfirm: true,
        }).then(result => {
          if (result.value) {
            this.$store.dispatch('auth/logout')
          }
        })
      },
    },
  }
</script>

<style lang="css" scoped>
.icon {
  color: #0181c4 !important;
}
.item {
  color: #0181c4 !important;
  caret-color: #004b8d !important;
  font-family: -apple-system, BlinkMacSystemFont, sans-serif !important;
}

.item :selection {
  color: #0181c4 !important;
  background-color: white !important;
  text-shadow: none;
}

.item:not(.item--active):not(.item--disabled) {
  color: #0181c4 !important;
}
</style>
