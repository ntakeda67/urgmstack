<template>
  <div id="app" class="section">
    <div id="login" class="box">
      <div class="field">
        <label class="label">User ID</label>
        <p class="control">
          <input class="input" type="text" v-model="name">
        </p>
      </div>
      <div class="field">
        <label class="label">Password</label>
        <p class="control">
          <input class="input" type="password" v-model="name">
        </p>
      </div>
      <div class="field is-grouped">
        <p class="control">
          <button class="button is-primary" @click="login">Login</button>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from '../api/http.js'

export default {
  data() {
    return {
      userId: '',
      password: ''
    }
  },
  methods: {
    login() {
    }
  }
}
</script>

<style lang="sass">
@import '~bulma/sass/utilities/initial-variables'

html,
body,
#app
  height: 100%

#app
  background-color: $grey-dark

#login
  width: 400px
  margin: auto
</style>
