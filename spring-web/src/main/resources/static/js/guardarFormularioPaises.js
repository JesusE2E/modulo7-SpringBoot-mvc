function guardarFormularioPais(){

const formularioPaisDto={
   paisId: document.getElementById("pais").value,
   ciudadId: document.getElementById("ciudad").value
};


fetch("/utilerias/guardar_Paises_Ciudad",{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify(formularioPaisDto)
})
.then(response=> response.json())
.then(data=>{
alert('El idPais es: '+data.paisId+ ' '+'El IdCiudadEs: '+data.ciudadId)
});


}