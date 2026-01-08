const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
require('dotenv').config();

// Configuración de la URI de MongoDB
const uri = `mongodb+srv://${process.env.USER}:${process.env.PASSWORD}@cluster0.y1noj1v.mongodb.net/${process.env.DBNAME}?retryWrites=true&w=majority`;

// Conectar a MongoDB
mongoose.connect(uri)
  .then(() => console.log('Base de datos conectada'))
  .catch(e => console.log('Error al conectar a la base de datos:', e));

const app = express();
const port = process.env.PORT || 3000;

// Configurar motor de vistas EJS
app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');

// Middleware para parsear datos del body
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// Servir archivos estáticos
app.use(express.static(__dirname + '/public'));
app.use(express.static(__dirname + '/views'));

// Rutas principales
app.use('/', require('./router/rutas'));

app.use('/usuarios', require('./router/usuario'));


// Ruta 404 - Página no encontrada
app.use((req, res) => {
  res.status(404).send('Página no encontrada');
});

// Iniciar servidor
app.listen(port, () => {
  console.log(`Servidor MatchBand corriendo en puerto ${port}`);
  console.log(`http://localhost:${port}`);
});