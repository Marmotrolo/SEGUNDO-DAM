const express = require('express');
const router = express.Router();
const Usuario = require('../models/usuario');

// Vista para crear usuario
router.get('/crear', (req, res) => {
    res.render('usuarios/crear');
});

// Listar todos los usuarios
router.get('/', async (req, res) => {
    try {
        const arrayUsuariosDB = await Usuario.find();
        console.log(arrayUsuariosDB);
        res.render("usuarios/usuarios", { 
            arrayUsuarios: arrayUsuariosDB
        });
    } catch (error) {
        console.error(error);
    }
});

// Ver detalle de un usuario
router.get('/:id', async(req, res) => {
    const id = req.params.id;
    try {
        const usuarioDB = await Usuario.findOne({ _id: id });
        console.log(usuarioDB);
        res.render('usuarios/detalle', {
            usuario: usuarioDB,
            error: false
        });
    } catch (error) {
        console.log('Se ha producido un error', error);
        res.render('usuarios/detalle', {
            error: true,
            mensaje: 'Usuario no encontrado!'
        });
    }
});

// Crear usuario (POST)
router.post('/', async (req, res) => {
    const body = req.body;
    console.log(body);
    try {
        const usuarioDB = new Usuario(body);
        await usuarioDB.save();
        res.redirect('/usuarios');
    } catch (error) {
        console.log('error', error);
    }
});

// Eliminar usuario
router.delete('/:id', async (req, res) => {
    const id = req.params.id;
    console.log('id desde backend', id);
    try {
        const usuarioDB = await Usuario.findByIdAndDelete({ _id: id });
        console.log(usuarioDB);
        if (!usuarioDB) {
            res.json({ 
                estado: false,
                mensaje: 'No se puede eliminar el usuario.'
            });
        } else {
            res.json({
                estado: true,
                mensaje: 'Usuario eliminado.'
            });
        } 
    } catch (error) {
        console.log(error);
    }
});

// Actualizar usuario
router.put('/:id', async (req, res) => {
    const id = req.params.id;
    const body = req.body;
    console.log(id);
    console.log('body', body);
    try {
        const usuarioDB = await Usuario.findByIdAndUpdate(
            id, body, { useFindAndModify: false }
        );
        console.log(usuarioDB);
        res.json({
            estado: true,
            mensaje: 'Usuario editado'
        });
    } catch (error) {
        console.log(error);
        res.json({
            estado: false,
            mensaje: 'Problema al editar el usuario'
        });
    }
});

module.exports = router;