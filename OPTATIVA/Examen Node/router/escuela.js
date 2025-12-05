const express = require('express'); // Requerimos Express
const router = express.Router();

router.get('/', (req, res) => {
    res.render("escuelas", { 
        arrayPokemon: [ 
            {id: 'e1', nombre: 'Torre de los guzmanes', descripcion:'Muy bonito'},
            {id: 'e2', nombre: 'IES Carmen Laffon', descripcion:'Malo'},
            {id: 'e3', nombre: 'PUA', descripcion:'Lamentable'}
        ]
    });
});

module.exports = router;
