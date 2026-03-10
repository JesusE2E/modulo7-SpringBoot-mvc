document.getElementById('categoria').addEventListener("change",function(){

const categoriaId=this.value;
const productoSelect=document.getElementById("producto");
productoSelect.innerHTML = '<option value="">SEleCCioNA una OPCIOn</option>';



if(categoriaId){
let option;


fetch('/utilerias/productos/'+categoriaId)
.then(res=>res.json())
.then(data=>{

data.forEach(p=>{

 let option =document.createElement("option");
option.value=p.idProducto;
option.text=p.nombre;
productoSelect.appendChild(option);
});
});

}




})