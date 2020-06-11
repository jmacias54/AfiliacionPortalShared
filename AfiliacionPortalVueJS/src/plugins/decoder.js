export default {
    install (Vue, options) {
        Vue.prototype.$decoder = (text) => {
            var textArea = document.createElement('textarea')
            textArea.innerHTML = text
            return textArea.value
        }
    },
}
