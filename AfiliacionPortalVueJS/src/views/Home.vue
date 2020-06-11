<template>
  <div>
    <v-row align="center" justify="center">
      <h1
        class="display-2 font-weight-thin mb-4 inicio-txt"
        color="darkish-blue"
      >
        {{ mensaje }}
      </h1>
      <h4 class="subheading inicio-txt">
        {{ $decoder(system) }}
      </h4>
    </v-row>
    <v-row align="center" justify="center">
      <h4 class="subheading inicio-txt">
        {{ nombre }}
      </h4>
    </v-row>
  </div>
</template>

<script>
export default {
  data: () => ({
    mensaje: "Bienvenido",
    system: "MIT Afiliaci&oacute;n",
    usuario: {},
    nombre: ""
  }),
  created() {
    // this.currentRoute = this.$route.matched[1].meta.name || this.$route.name
    this.usuario = JSON.parse(sessionStorage.getItem("user"));
    this.iniciales =
      this.usuario.nombre.charAt(0) + this.usuario.apellidoPaterno.charAt(0);
    this.nombre =
      this.usuario.nombre +
      " " +
      this.usuario.apellidoPaterno +
      " " +
      this.usuario.apellidoMaterno;
  },
  methods: {

  }
};
</script>

<style>
.inicio-txt {
  color: #0181c4 !important ;
  font-family: -apple-system, BlinkMacSystemFont, sans-serif !important;
}
</style>
