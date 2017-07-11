<template>
  <div class="section">
    <h1 class="title">Pages</h1>
    <p class="field">
      <button class="button is-info" @click="toPage1">
        Page1
      </button>
      <button class="button is-primary" @click="toPage2">
        Page2
      </button>
    </p>
    <component :is="view"></component>
  </div>
</template>

<script>
import Page1 from './Page1.vue'
import Page2 from './Page2.vue'

export default {
  data() {
    return {
      view: Page1
    }
  },
  methods: {
    toPage1() {
      this.view = Page1
    },
    toPage2() {
      this.view = Page2
    }
  },
  mounted() {
    this.$on('to-page1', () => this.toPage1())
    this.$on('to-page2', () => this.toPage2())
  }
}
</script>

<style lang="sass" scoped>
</style>
