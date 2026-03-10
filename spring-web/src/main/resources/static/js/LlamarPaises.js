document.getElementById('pais').addEventListener("change",function(){

const paisId=this.value;
const ciudadSelect=document.getElementById("ciudad");
ciudadSelect.innerHTML = '<option value="">SELECCIONA UNA OPICION</option>';

console.log("fuera"+paisId)

if(paisId){
console.log("dentro"+paisId)
let option;


fetch('/utilerias/listasCiudadPaisJS/'+paisId)
.then(res=>res.json())
.then(data=>{

data.forEach(p=>{
console.log('foreach')
 let option =document.createElement("option");
option.value=p.idCiudad;
option.text=p.nombre;
ciudadSelect.appendChild(option);
});
});





}




})