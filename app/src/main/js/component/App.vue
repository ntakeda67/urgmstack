<template>
  <div id="app" class="section">
    <h1 class="title">Spring Boot + Doma + Vue Sample</h1>
    <div class="content">
      <ul>
        <li v-for="menuItem in menuItems" :key="menuItem">
          <a :href="menuItem + '.html'">{{ menuItem }}</a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      menuItems: [
        'hello',
        'login',
        'pages',
        'grid'
      ]
    }
  }
}
</script>

<style lang="sass" scoped>
</style>
