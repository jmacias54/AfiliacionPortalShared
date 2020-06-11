<template>
  <v-content class="bg">
    <v-container
      class="fill-height"
      fluid
    >
      <v-row
        align="center"
        justify="center"
      >
        <v-col
          cols="12"
          sm="8"
          md="4"
        >
          <v-card class="mx-auto">
            <v-toolbar flat>
              <v-tooltip bottom>
                <template v-slot:activator="{ on }">
                  <v-btn
                    icon
                    large
                    target="_blank"
                    v-on="on"
                  >
                    <v-avatar>
                      <img
                        src="../assets/prof-ico.png"
                        alt="Profuturo"
                        height="34"
                      >
                    </v-avatar>
                  </v-btn>
                </template>
                <span>Profuturo</span>
              </v-tooltip>
              <v-spacer />

              <v-toolbar-title>
                <span color="prof_txt_1">Ingresar</span>
              </v-toolbar-title>
            </v-toolbar>
            <v-card-text>
              <v-form
                id="check-login-form"
                @submit.prevent="validateBeforeSubmit"
              >
                <v-text-field
                  v-model="form.usuario"
                  label="Usuario"
                  name="usuario"
                  prepend-icon="mdi-account"
                  type="text"
                />

                <v-text-field
                  id="contrasena"
                  v-model="form.contrasena"
                  :label="txt.password_txt"
                  name="contrasena"
                  prepend-icon="mdi-lock"
                  type="password"
                />
              </v-form>
            </v-card-text>
            <v-card-actions>
              <v-spacer />
              <v-btn
                text
                color="primary"
                class="body-1"
              >
                {{ txt.forgot_passwrd_txt }}
              </v-btn>
              <v-spacer />
              <v-btn
                type="submit"
                color="primary"
                form="check-login-form"
                :loading="form.cargando"
                :disabled="form.cargando"
              >
                {{ txt.iniciar_sesion }}
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-content>
</template>
<script>
  import { mapGetters } from 'vuex'

  export default {
    data () {
      return {
        form: {
          usuario: '',
          contrasena: '',
          sendingForm: false,
          cargando: false,
        },
        txt: {
          password_txt: '',
          forgot_passwrd_txt: this.$decoder(
            '&iquest;Olvidaste tu contrase&ntilde;a?'
          ),
          iniciar_sesion: this.$decoder('Iniciar sesi&oacute;n'),
        },
      }
    },

    beforeCreate: () => {
      document.body.className = 'full-page'
    },

    created () {
      this.txt.password_txt = this.$decoder('Contrase&ntilde;a')
      this.$store.dispatch('auth/initAuth')
    },

    computed: {
      ...mapGetters({
        loginStatus: 'auth/status',
      }),
    },

    methods: {
      validateBeforeSubmit () {
        console.log(' -- validateBeforeSubmit -- ')
        this.form.cargando = true
        if (this.form.usuario == null || this.form.usuario === '') {
          this.form.cargando = false

          this.$swal({
            icon: 'warning',
            title: this.$decoder('Campo obligatorio (Usuario)...'),
            text: this.$decoder('favor de ingresar el usuario..!'),
            type: 'warning',

            showCloseButton: true,
            showLoaderOnConfirm: true,
          })
        }
        if (this.form.contrasena == null || this.form.contrasena === '') {
          this.form.cargando = false
          this.$swal({
            icon: 'warning',
            title: this.$decoder('Campo obligatorio (Contrase&ntilde;a)...'),
            text: this.$decoder('favor de ingresar la contrase&ntilde;a ..!'),
            type: 'warning',

            showCloseButton: true,
            showLoaderOnConfirm: true,
          })
        }

        this.handleSubmit()
      },

      getMsgError (status) {
        if (status === 401) {
          return 'El usuario o la contrase&ntildea son incorrectos'
        }

        return 'Ha ocurrido un error, vuelve intentarlo más tarde'
      },

      handleSubmit () {
        console.log(' -- handleSubmit -- ')
        const { usuario, contrasena } = this.form
        this.form.sendingForm = true

        this.$store
          .dispatch('auth/login', { usuario, contrasena })
          .catch(({ status }) => {
            this.form.cargando = false
            this.$swal({
              icon: 'warning',
              title: 'Credenciales invalidas...',
              text: this.$decoder('Usuario o contrase&ntilde;a invalido.!'),
              type: 'warning',
              showCloseButton: true,
              showLoaderOnConfirm: true,
            })
          })
          .finally(() => {
            this.form.sendButtonText = 'Ingresar a mi cuenta'
            this.form.sendingForm = false
          })
      },
    },
  }
</script>
<style scoped>
.bg {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
  background: url(../assets/bg/login.png) no-repeat center;
  background-size: cover;
  background-color: #004b8d !important;
  transform: scale(1.1);
}
</style>
