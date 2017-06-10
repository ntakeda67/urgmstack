import test from 'ava'
import hello from '../api/helloworld'

test('hello', t => {
  t.is(hello('world'), 'Hello, world!')
})
