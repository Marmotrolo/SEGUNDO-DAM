const express = require('express') 
const router = express.Router();


router.get('/', (req, res) => {
    res.render("peques", { 
        arrayPokemon: [ 
            {id: 'p1', nombre: 'Manolo', descripcion:'Muy bonito'},
            {id: 'p2', nombre: 'Ñuis', descripcion:'Malo'},
            {id: 'p3', nombre: 'Pablo', descripcion:'Lamentable'}
        ]
    })
})
module.exports = router;
