const express = require('express')
//Conexión a base de datos
const mongoose = require('mongoose');
//Variables que tendremos siempre:
//Lo correcto será declararlas EN VARIABLES DE ENTORNO
//para que nadie vea directamente nuestras credenciales
const user = 'mpartor0311_db_user';
const password = 'm4nu3l123456';
const dbname = 'pokemon';
const uri = `mongodb+srv://${user}:${password}@cluster0.y1noj1v.mongodb.net/${dbname}?retryWrites=true&w=majority`; //URL de conexión, que completaremos luego
mongoose.connect(uri,
  { useNewUrlParser: true, useUnifiedTopology: true }
)
  .then(() => console.log('Base de datos conectada'))
  .catch(e => console.log(e))

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
