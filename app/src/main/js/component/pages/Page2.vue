<template>
  <div class="section">
    <h1 class="title">Page2</h1>
    <p>{{ value }}</p>
    <p class="field">
      <button class="button is-info" @click="toPage1">
        Page1
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
    toPage1() {
      this.$parent.$emit('to-page1')
    }
  },
  activated() {
    this.value = store.state.value
  }
}
</script>

<style lang="sass" scoped>
</style>
