const express = require('express')
const app = express()
const port = 3000

app.set('view engine', 'ejs')


app.use(express.static(__dirname+ '/public'));
app.use(express.static( __dirname +'/views'));

app.use('/', require('./router/rutas'));
app.use('/pokemon', require('./router/pokemon'));
app.use("/contacto", require('./router/rutas'));

app.get('/prueba', (req, res) => {
  console.log(__dirname)
  res.render ("prueba", {titulo:"Mi titulo dinamico"})

})
app.get('/contacto.html', (req, res) => {
 console.log(__dirname)

  res.send('Hello contacto !')
})
app.get('/product.html', (req, res) => {
 console.log(__dirname)

  res.send('Hello contacto !')
})
app.use((req,res)=>{
  res.status(404).sendFile(__dirname + "/public/html/404.html")
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
