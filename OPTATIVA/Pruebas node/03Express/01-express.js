const express = require('express')
const app = express()
const port = 3000

app.use(express.static(__dirname+ '/public'));


app.get('/', (req, res) => {
    console.log(__dirname)
  res.send('Hello !')
})
app.get('/contacto', (req, res) => {
 console.log(__dirname)

  res.send('Hello contacto !')
})
app.get('/product', (req, res) => {
 console.log(__dirname)

  res.send('Hello contacto !')
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
