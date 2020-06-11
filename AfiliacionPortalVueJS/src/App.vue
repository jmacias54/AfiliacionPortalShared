<template>
  <v-app>
    <v-content id="appvue-content">
      <v-fade-transition>
        <router-view />
      </v-fade-transition>
    </v-content>
  </v-app>
</template>

<script>
  export default {
    components: {},

    methods: {
      decoder (str) {
        var textArea = document.createElement('textarea')
        textArea.innerHTML = str
        console.log(textArea.value)

        return textArea.value
      },
    },
  }
</script>
