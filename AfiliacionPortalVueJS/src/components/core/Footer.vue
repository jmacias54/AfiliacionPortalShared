<template>
  <v-footer
    id="core-footer"
    absolute
  >
    <v-spacer />
    <span class="font-weight-light copyright">
      &copy;
      {{ (new Date()).getFullYear() }}
      <a
        href="http://profuturo.com.mx/"
        target="_blank"
      >Profuturo</a>

    </span>
  </v-footer>
</template>

<script>
  export default {
    data: () => ({

    }),
  }
</script>

<style>
#core-footer {
  z-index: 0;
}
</style>
