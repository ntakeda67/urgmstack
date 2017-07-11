<template>
  <div class="section">
    <h1 class="title">Page1</h1>
    <p class="field">
      <button class="button is-primary" @click="toPage2">
        Page2
      </button>
    </p>
  </div>
</template>

<script>
export default {
  data() {
    return {
    }
  },
  methods: {
    toPage2() {
      this.$parent.$emit('to-page2')
    }
  }
}
</script>

<style lang="sass" scoped>
</style>
