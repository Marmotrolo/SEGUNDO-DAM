// 00_server_test.js
const express = require('express');
const app = express();
const port = 3000;

app.set('view engine', 'ejs');

app.use(express.static(__dirname + '/public'));

app.use('/', require('./router/rutas'));       
app.use('/escuelas', require('./router/escuela')); 
app.use('/peques', require('./router/peques')); 


app.get('/public/pepnogato.jpg', (req, res) => {
  console.log(__dirname);
  res.send("hola");
});
app.get('/contacto', (req, res) => {
  console.log(__dirname);
  res.render("contacto");
});

app.listen(port, () => {
  console.log(`Servidor escuchando en http://localhost:${port}`);
});
