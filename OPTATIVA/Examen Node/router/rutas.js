const express = require('express') //Requerimos Express
const router = express.Router();

// Ahora, CORTAMOS del fichero principal 01-express.js
// las dos rutas que tenemos: la principal ( / ) y la 
// de contactos ( /contaco )
// Importante que ya no usaremos el app.get(...), ahora
//vamos a utilizar las rutas, por lo que deberemos poner:
router.get('/', (req, res) => {
    res.render("index", { titulo: "Escuelas infantiles" })
})

router.get('/contacto', (req, res) => {
    res.render("contacto", { tituloContacto: "Estamos en contacto de manera dinámica!!" })
})
router.get('/inicio', (req, res) => {
    res.render("inicio", { tituloContacto: "Estamos en inicio" })
})
router.get('/quienessomos', (req, res) => {
    res.render("quienes somos", { tituloContacto: "Estamos en quienes somos" })
})
router.get('/nuestrasescuelas', (req, res) => {
    res.render("nuestras escuelas", { tituloContacto: "Estamos en nuestras escuelas" })
})

// Por último, vamos a exportarlo:
module.exports = router;
