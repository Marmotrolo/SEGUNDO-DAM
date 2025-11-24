/* global use, db */
// MongoDB Playground
// Use Ctrl+Space inside a snippet or a string literal to trigger completions.

const database = 'peliculas';
const collection = 'estudiantes';

// Create a new database.
use(database);

// Create a new collection.
//db.createCollection("estudiantes");




db.estudiantes.find().sort({"name":1});