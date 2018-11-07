var botao = document.querySelector("#bt-criar");

botao.addEventListener('click',function () {


    var formulario = document.querySelector("#usuario");
    var usuario = {
        nome: formulario.querySelector("#txt-nome").value,
        nascimento: formulario.querySelector("#txt-nascimento").value,
        sexo: formulario.querySelector("#txt-sexo").value,
        email: formulario.querySelector("#txt-email").value,
        senha1: formulario.querySelector("#txt-senha1").value,
        senha2: formulario.querySelector("#txt-senha2").value
    };

   var erros = validaUsuario(usuario);
   var ul = document.querySelector("#mensagens-erro");
   ul.textContent = "";
   
   if (erros.length > 0) {
	    event.preventDefault();
	    ul.classList.add("pt-2")
	   for(let i=0;i<erros.length;i++){
		   var li = document.createElement("li");
		   li.textContent = erros[i];
		   ul.appendChild(li);
	   }
   } 
});