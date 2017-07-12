<template>
  <div class="section">
    <h1 class="title">Grid</h1>
    <div class="panel">
      <div class="panel-heading">
        condition
      </div>
      <div class="panel-block">
        <div class="content">
          <div class="field has-addons">
            <p class="control">
              <input type="text" class="input" v-model="condition">
            </p>
            <p class="control">
              <button class="button is-primary" @click="search" :disabled="condition == ''">
                Search
              </button>
            </p>
          </div>
        </div>
      </div>
    </div>
    <div id="grid"></div>
  </div>
</template>

<script>
import Handsontable from 'handsontable'
import 'handsontable/dist/handsontable.css'
import http from 'axios'

const iconRenderer = (instance, td, row, col, prop, value, cellProperties) => {
  const escaped = Handsontable.helper.stringify(value)

  const img = document.createElement('img')
  img.src = value

  td.appendChild(img);

  return td;
}

export default {
  data() {
    return {
      condition: '',
      hot: null
    }
  },
  methods: {
    search() {
      if (this.hot) {
        this.hot.destroy()
      }
      http.get('https://api.github.com/search/users', {
        params: {
          q: this.condition
        }
      })
        .then(resp => resp.data.items)
        .then(data => {
          const element = document.getElementById('grid')
          const columns = [
            { data: 'avatar_url', renderer: iconRenderer },
            { data: 'login' }
          ]
          this.hot = new Handsontable(element, { data, columns })
        })
    }
  }
}
</script>

<style lang="sass" scoped>
</style>
