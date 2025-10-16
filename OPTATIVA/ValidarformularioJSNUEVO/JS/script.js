
var nombre;
var formulariogordo;
var botonregistrar;

function iniciarpagina(){
  nombre= document.getElementById("nombre");
  formulariogordo= document.getElementById("formulariogordo");
  botonregistrar = document.getElementById("botonregistrar");

  botonregistrar.onclick = validanombre;
}

function validanombre(){

  if(nombre.value.length<=2){
    alert("putamierda")
  }
  else{
    alert("ok")
  }


}