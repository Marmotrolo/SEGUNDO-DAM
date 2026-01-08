const express = require('express');
const router = express.Router();

// Ruta principal / home con menú
router.get('/', (req, res) => {
    res.render("index", { 
        titulo: "MatchBand - Conecta con músicos"
    });
});

module.exports = router;
