<template>
  <div class="section">
    <h1 class="title">Page1</h1>
    <div class="field">
      <p class="control">
        <input type="text" class="input" v-model="value">
      </p>
    </div>
    <p class="field">
      <button class="button is-primary" @click="toPage2">
        Page2
      </button>
    </p>
  </div>
</template>

<script>
import store from './pages-store.js'

export default {
  data() {
    return {
      value: ''
    }
  },
  methods: {
    toPage2() {
      store.dispatch('updateValue', this.value)
      this.$parent.$emit('to-page2')
    }
  }
}
</script>

<style lang="sass" scoped>
</style>
