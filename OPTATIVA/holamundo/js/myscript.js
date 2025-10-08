//alert("Hello to JS")

function $ (selector){
    return document.querySelector (selector);
}
/*console.log("ola ke ase")

var table = "Normal table";
let chair = "One chair";

console.log (table);
console.log (chair);

let testboolean= true;
console.log(testboolean);

let testnumber= 10;
console.log(testnumber);

let testString ='text';
console.log (testString);

let testbooleanobject= new Boolean(true);
console.log(testbooleanobject)

let testnumberobject = new Number(10);
console.log (testnumberobject);

let testStringobject = new String ('text')
console.log (testStringobject);


console.log(testStringobject.toUpperCase());

let question= `How old is $(test) $(surname) adfs`

let operador_a =3;
let operador_b =3;

let expo= operador_a ** operador_b;
let inc= operador_a++;
let dec= --operador_a;

console.log(expo)
console.log(inc)
console.log(dec)

console.log (typeof(testboolean))
console.log (typeof(testnumber))

let testnull= null;
console.log(typeof(testnull))


var first_array = [];
var secondarray= new Array(3);
var third_array= new Array (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
var fifth_array= new Array (3,5,7,9);
var sixth_array= [third_array, fifth_array];


var fourth_array= new Array (3,5,"Seville",true, third_array);
console.log(first_array)
console.log (fourth_array)
console.log (secondarray)
console.log (third_array)

console.log(fourth_array.push("Spain"))
console.log(fourth_array[5])
console.log (sixth_array);
sixth_array[1][1] =8;
third_array[1] = 9;
console.log (sixth_array)

/*for( var i =0; third_array.length > i; i++ ){
    console.log(third_array[i]);
}*/

/*for (var i=third_array.length-1; i>=0; i--){
    console.log(third_array[i]);
}*/

/*var i =third_array.length-1;
for(;i>=0;i--){
    console.log (third_array[i])
}

third_array.forEach(function myFunction(item){
    console.log(item)
});

let today =new Date();
let first_october= new Date(2025,9,1);
console.log(today);
console.log(first_october)

console.log(today.getDay());

if (today>first_october){
    console.log ("Today is after to first octuber")
}
else{
    console.log("Today is before to first october")
}


function myFirstFunction(){
    console.log ("ola")
}
function mySecondFunction(){
    console.log("Thank u for ur interest")
}
function myThirdFunction(mensaje) {
    console.log('Pesao')
    console.log(mensaje)
}

var div =document.getElementById("my_div");
div.classList.add("my_class");
console.log (div)

var div = document.getElementsByTagName("div");
console.log(div);

var second_div= document.querySelector("#my_seconddiv");
console.log (second_div); 
*/



console.log("#my_third_div")
 console.log(".pruebas")
$("#btn").addEventListener("click",function(){
    var input = document.createElement("ola");
    input.setAttribute("type","email");
    input.setAttribute("placeholder","E-mail");
    input.setAttribute("name", "emails[]");
    $("#form").appendChild(input);
    myAlert("add new email input");
});

function myAlert(msg){
    var div= document.createElement("div");
    div.classList.add("alert");
    div.innerHTML= msg;
    $("body").insertBefore(div,$("body").firstChild);
}