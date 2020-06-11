<template>
  <div>
    <v-app-bar
      id="core-app-bar"
      color="transparent"
      flat
    >
      <v-toolbar-title
        id="header-bar"
        class="tertiary--text font-weight-light align-self-center"
      >
        <v-btn
          v-if="responsive"
          color="prof_txt_1"
          icon
          @click.stop="onClick"
        >
          <v-icon>mdi-view-list</v-icon>
        </v-btn>
        <span class="sn-fco-font">{{ title }}</span>
      </v-toolbar-title>

      <v-spacer />

      <v-toolbar-items>
        <v-row
          align="center"
          class="mx-0"
        >
          <v-btn
            icon
            to="/"
          >
            <v-icon color="prof_txt_1">
              mdi-view-dashboard
            </v-icon>
          </v-btn>
        </v-row>
      </v-toolbar-items>
    </v-app-bar>
  </div>
</template>

<script>
// Utilities
  import { mapMutations } from 'vuex'

  export default {
    data: () => ({
      title: null,
      responsive: false,
    }),

    watch: {
      $route (val) {
        this.title = this. $decoder(val.meta.text)
      },
    },

    mounted () {
      this.onResponsiveInverted()
      window.addEventListener('resize', this.onResponsiveInverted)
    },
    beforeDestroy () {
      window.removeEventListener('resize', this.onResponsiveInverted)
    },

    methods: {
      ...mapMutations('app', ['setDrawer', 'toggleDrawer']),
      onClick () {
        this.setDrawer(!this.$store.state.drawer)
      },
      onResponsiveInverted () {
        if (window.innerWidth < 991) {
          this.responsive = true
        } else {
          this.responsive = false
        }
      },

  
    },
  }
</script>

<style>
#core-app-bar a {
  text-decoration: none;
  width: auto;
  height: 40%;
  left: 6px !important;
}
.sn-fco-font {
  font-family: -apple-system, BlinkMacSystemFont, sans-serif !important;
  color: #0181c4;
}
</style>
