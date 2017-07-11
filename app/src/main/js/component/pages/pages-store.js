import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const state = {
    value: ''
}

const mutations = {
    updateValue: (state, value) => state.value = value
}

const actions = {
    updateValue({ commit }, value) {
        commit('updateValue', value)
    }
}

export default new Vuex.Store({
    state, mutations, actions
})
