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
  apellidos= document.getElementById("apellidos");
  email = document.getElementById("email");
  telefono= document.getElementById("telefono");
  numpaisorigen= document.getElementById("numeropais")
  fecha=document.getElementById("fecha");
  dni=document.getElementById("dni");
  direccion=document.getElementById("direccion");
  contraseña= document.getElementById("contraseña")
  confirmacontraseña=document.getElementById("confirmacontraseña")
  masculino=document.getElementById("masculino")
  femenino=document.getElementById("femenino")
  checkcaja=document.getElementById("checkcaja")

  

campoApellidos=document.getElementById("campoApellidos");
  campoEmail = document.getElementById("campoEmail");
campoTelefono=document.getElementById("campoTelefono");
campoFecha=document.getElementById("campoFecha");
campoDNI= document.getElementById("campoDNI");
campoDireccion=document.getElementById("campoDireccion");
campoContraseña= document.getElementById("campoContraseña")
campoGenero= document.getElementById("campoGenero")
campoCheck= document.getElementById("campoCheck")

  botonvalidar = document.getElementById("botonrvalidar");
  botonenviar=document.getElementById("botonenviar")

  botonvalidar.onclick = validanombre;

  
  };


function validanombre(){
  let expresionregularnombre= /^[A-Za-zÁÉÍÓÚáéíóúñÑ\s]+$/;
  if(!expresionregularnombre.test(nombre.value)){
    alert("El nombre no debe contener números");
  } else {
    campoApellidos.style.display = "block";
    botonvalidar.onclick = validaapellidos;
  
  }
}
function validaapellidos(){
  let expresionregularapellidos= /^[A-Za-zÁÉÍÓÚáéíóúñÑ\s]+$/;
  if(!expresionregularapellidos.test(apellidos.value)){
    alert("Los apellidos no debe contener números");
  } else {
    campoEmail.style.display = "block";
    botonvalidar.onclick = validaemail;
  
  }
}

function validaemail(){
  let expregularemail=/^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i
  if(!expregularemail.test(email.value) ){
    alert("Pon un email válido (debe contener @.xxx) ");
  } else {
    campoTelefono.style.display="block"
    botonvalidar.onclick = validatelefono;

  }

}
function validatelefono(){
 let expresionregularnumpaisorigen= /\+\d{1,3}/
  if( telefono.value.length!= 9 || !expresionregularnumpaisorigen.test(numpaisorigen.value))  {
    alert("Pon un telefono válido (9 dígitos) o inserta un número de pais de origen válido (+)");
  } else {
    campoFecha.style.display="block"
    botonvalidar.onclick = validafecha;

  }
}

function validafecha(){
 
  let nacimientousuario= new Date(fecha.value)
  let fechahoy= new Date(); 
  
if(fechahoy.getFullYear() - nacimientousuario.getFullYear() <= 18){
    alert("Debe ser mayor o igual que 18");
  } else {
    campoDireccion.style.display="block"
    botonvalidar.onclick = validadireccion;

  }
}

function validadireccion(){
  let expresionregulardireccion= /^[a-zA-Z0-9À-ÿ\s,.-]{5,}$/;
;
 
   if( !expresionregulardireccion.test(direccion.value) ){
     alert("Pon una dirección válida (mínimo 5 caracteres, letras o números)");
   } else {
     campoDNI.style.display="block"
     botonvalidar.onclick = validadni;
 
   }
 }
 

function validadni(){
 let expresionregulardni= /^\d{8}[A-Za-z]$/;

  if( !expresionregulardni.test(dni.value) ){
    alert("Pon un DNI válido");
  } else {
    campoContraseña.style.display="block"
    botonvalidar.onclick = validacontraseña;

  }
}



function validacontraseña(){
if(contraseña.value !== confirmacontraseña.value){
alert("Las contraseñas no coindicen")
}
else{
campoGenero.style.display="block";
botonvalidar.onclick= validagenero;
}
}


function validagenero(){

  if( !masculino.checked && !femenino.checked ){
    alert("Selecciona un genero");
  } else {
   campoCheck.style.display="block"
   botonvalidar.onclick=validacheckbox
  }
}


function validacheckbox(){
  if(!checkcaja.checked){
    alert("Acepta para enviar")
  }
  else{
    
  botonenviar.disabled=false
  botonenviar.onclick = function() {
    alert("Enviado correctamente");
    

  }
}
}

