<template>
  <div class="section">
    <h1 class="title">Page2</h1>
    <p class="field">
      <button class="button is-info" @click="toPage1">
        Page1
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
    toPage1() {
      this.$parent.$emit('to-page1')
    }
  }
}
</script>

<style lang="sass" scoped>
</style>
