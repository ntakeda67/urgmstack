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
import 'bulma/css/bulma.css'
import axios from 'axios'

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
      axios.get('/api/hello?name=' + name).then(resp => this.message = resp.data)
    }
  }
}
</script>

<style lang="sass" scoped>
</style>
