const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const usuarioSchema = new Schema({
    nombre: String,
    email:  String,
    password:String,
    instrumento: String, 
    generoMusical: [String],
    nivel: String, enum: ['Principiante', 'Intermedio', 'Avanzado', 'Profesional'],
    ciudad: String,
    biografia: String,
    rol: String, enum: ['normal', 'profesional', 'admin'],
    verificado:  Boolean,
   
});

const Usuario = mongoose.model('usuario', usuarioSchema, "usuarios");

module.exports = Usuario;