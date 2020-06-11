import Vue from 'vue'
import Vuetify from 'vuetify/lib'
import es from 'vuetify/lib/locale/es';

Vue.use(Vuetify)

export default new Vuetify({
  theme: {
    themes: {
      light: {
        primary: '#004b8d',
        secondary: '#ffc000',
        tertiary: '#0181c4',
        accent: '#82B1FF',
        error: '#d0021b',
        info: '#00d3ee',
        success: '#53b312',
        warning: '#fdbd2c',
        profPrimary: '#004b8d',
        profSecondary: '#ffc000',
        prof_tertiary: '#7fb8e6',
        prof_tertiary_2: '#4cbbee',
        prof_tertiary_3: '#3eb6bb',
        prof_background_1: '#374047',
        prof_background_2: '#374047',
        prof_background_3: '#dadfe9',
        prof_background_withe: '#ffffff',
        prof_txt_1: '#0181c4',
        prof_txt_2: '#ea7403',
        prof_txt_3: '#374047',
        prof_txt_4: '#979797',
        prof_txt_5: '#c5c5c5',
        prof_txt_6: '#ff0d55',
      },
      dark: {
        primary: '#1976D2',
        secondary: '#ffc000',
        accent: '#82B1FF',
        error: '#d0021b',
        info: '#2196F3',
        success: '#53b312',
        warning: '#fdbd2c',
      },
    },
  },
  icons: {
    iconfont: 'mdi',
  },
  lang: {
    locales: { es },
    current: 'es',
  },
})
