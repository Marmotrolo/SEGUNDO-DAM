var nombre;
var apellidos;
var email;
var telefono;
var numpaisorigen;
var fecha;
var dni;
var direccion;
var contraseña;
var confirmacontraseña;
var masculino;
var femenino;
var checkcaja;
var campoApellidos;
var campoEmail;
var campoTelefono;
var campoFecha;
var campoDNI;
var campoDireccion;
var campoContraseña;
var campoGenero;
var campoCheck;
var formulariogordo;
var botonvalidar;
var botonenviar;

function iniciarpagina(){
  formulariogordo = document.getElementById("formulariogordo");

  nombre = document.getElementById("nombre");
  apellidos = document.getElementById("apellidos");
  email = document.getElementById("email");
  telefono = document.getElementById("telefono");
  numpaisorigen = document.getElementById("numeropais");
  fecha = document.getElementById("fecha");
  dni = document.getElementById("dni");
  direccion = document.getElementById("direccion");
  contraseña = document.getElementById("contraseña");
  confirmacontraseña = document.getElementById("confirmacontraseña");
  masculino = document.getElementById("masculino");
  femenino = document.getElementById("femenino");
  checkcaja = document.getElementById("checkcaja");

  campoApellidos = document.getElementById("campoApellidos");
  campoEmail = document.getElementById("campoEmail");
  campoTelefono = document.getElementById("campoTelefono");
  campoFecha = document.getElementById("campoFecha");
  campoDNI = document.getElementById("campoDNI");
  campoDireccion = document.getElementById("campoDireccion");
  campoContraseña = document.getElementById("campoContraseña");
  campoGenero = document.getElementById("campoGenero");
  campoCheck = document.getElementById("campoCheck");

  botonvalidar = document.getElementById("botonrvalidar");
  botonenviar = document.getElementById("botonenviar");

  botonvalidar.onclick = validanombre;

  checkcaja.onchange = function() {
  if (checkcaja.checked) {
    botonenviar.disabled = false;
  } else {
    botonenviar.disabled = true;
  }
};


}

function validanombre(){
  let expresionregularnombre = /^[A-Za-zÁÉÍÓÚáéíóúñÑ\s]+$/;
  if (!expresionregularnombre.test(nombre.value)) {
    alert("El nombre no debe contener números y no puede estar vacio");
  } else {
    campoApellidos.style.display = "block";
    botonvalidar.onclick = validaapellidos;
    return true;
  }
}

function validaapellidos(){
  let expresionregularapellidos = /^[A-Za-zÁÉÍÓÚáéíóúñÑ\s]+$/;
  if (!expresionregularapellidos.test(apellidos.value)) {
    alert("Los apellidos no deben contener números y no puede estar vacio");
  } else {
    campoEmail.style.display = "block";
    botonvalidar.onclick = validaemail;
    return true;
  }
}

function validaemail(){
  let expregularemail = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
  if (!expregularemail.test(email.value)) {
    alert("Pon un email válido (debe contener @.xxx) y no puede estar vacio");
  } else {
    campoTelefono.style.display = "block";
    botonvalidar.onclick = validatelefono;
    return true;
  }
}

function validatelefono(){
  let expresionregularnumpaisorigen = /\+\d{1,3}/;
  if (telefono.value.length != 9 || !expresionregularnumpaisorigen.test(numpaisorigen.value)) {
    alert("Pon un teléfono válido (9 dígitos) o inserta un número de país válido (+) y no puede estar vacio");
  } else {
    campoFecha.style.display = "block";
    botonvalidar.onclick = validafecha;
    return true;
  }
}

function validafecha(){
  let nacimientousuario = new Date(fecha.value);
  let fechahoy = new Date();
  if (fechahoy.getFullYear() - nacimientousuario.getFullYear() <= 18) {
    alert("Debe ser mayor o igual que 18");
  } else {
    campoDireccion.style.display = "block";
    botonvalidar.onclick = validadireccion;
    return true;
  }
}

function validadireccion(){
  let expresionregulardireccion = /^[a-zA-Z0-9À-ÿ\s,.-]{5,}$/;
  if (!expresionregulardireccion.test(direccion.value)) {
    alert("Pon una dirección válida (mínimo 5 caracteres, letras o números) y no puede estar vacio");
  } else {
    campoDNI.style.display = "block";
    botonvalidar.onclick = validadni;
    return true;
  }
}

function validadni(){
  let expresionregulardni = /^\d{8}[A-Za-z]$/;
  if (!expresionregulardni.test(dni.value)) {
    alert("Pon un DNI válido y no puede estar vacio");
  } else {
    campoContraseña.style.display = "block";
    botonvalidar.onclick = validacontraseña;
    return true;
  }
}

function validacontraseña(){
  if (contraseña.value !== confirmacontraseña.value) {
    alert("Las contraseñas no coinciden y no puede estar vacio");
  } else {
    campoGenero.style.display = "block";
    botonvalidar.onclick = validagenero;
    return true;
  }
}

function validagenero(){
  if (!masculino.checked && !femenino.checked) {
    alert("Selecciona un género");
  } else {
    campoCheck.style.display = "block";
    botonvalidar.onclick = validacheckbox;
    return true;
  }
}

function validacheckbox(escondido = false){
  if (!checkcaja.checked) {
    if (!escondido){
       alert("Acepta para enviar");
    }
    return false;
  } else {
    return true;
  }
}

function validarTodo() {
  if (
    validanombre() &&
    validaapellidos() &&
    validaemail() &&
    validatelefono() &&
    validafecha() &&
    validadireccion() &&
    validadni() &&
    validacontraseña() &&
    validagenero() &&
    validacheckbox(true)
  ) {
    alert("Enviado correctamente");
    return true;
  } else {
    return false;
  }
}