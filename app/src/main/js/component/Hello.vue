<template>
  <div id="app" class="section">
    <h1 class="title">{{ message }}</h1>
    <div class="content">
      <div class="field has-addons">
        <p class="control">
          <input class="input" type="text" v-model="name">
        </p>
        <p class="control">
          <button class="button" @click="hello">hello</button>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from '../api/http.js'

export default {
  data () {
    return {
      message: 'Hello, world!',
      name: ''
    }
  },
  methods: {
    hello() {
      const name = this.name
      axios.post('api/hello', { name })
        .then(resp => resp.data)
        .then(({ message }) => this.message = message)
    }
  }
}
</script>

<style lang="sass" scoped>
</style>
