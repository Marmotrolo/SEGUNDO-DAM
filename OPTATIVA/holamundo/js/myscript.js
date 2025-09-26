//alert("Hello to JS")

console.log("ola ke ase")

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
var third_array= new Array (3,5,7,8);
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
