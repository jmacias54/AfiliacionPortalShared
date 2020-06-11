<template>
  <v-container id="admin-content">
    <core-app-bar />
    <core-drawer />
    <core-view />
    <core-footer />
  </v-container>
</template>

<script>
  export default {
    components: {
      CoreDrawer: () => import('@/components/core/Drawer'),
      CoreFooter: () => import('@/components/core/Footer'),
      CoreAppBar: () => import('@/components/core/AppBar'),
      CoreView: () => import('@/components/core/View'),
    },
  }
</script>
