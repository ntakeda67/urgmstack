import axios from 'axios'

const csrfHeaderName = document.querySelector('meta[name=csrf-header-name]').getAttribute('content')
const csrfToken = document.querySelector('meta[name=csrf-token]').getAttribute('content')

const http = axios.create({
    headers: {
        post: {}
    }
})
http.defaults.headers.post[csrfHeaderName] = csrfToken

export default http