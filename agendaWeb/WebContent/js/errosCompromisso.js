var botao = document.getElementById("bt-criar")

function validaContato(compromisso) {
   
    var erros = [];

    if(compromisso.titulo.length == 0){
        erros.push ("O titulo é obrigatorio");
    }
    if(compromisso.data.length == 0){
        erros.push("O data é obrigatório.")
    }
    if(compromisso.inicio.length == 0) {
        erros.push ("A data é obrigatório.");
    }
    if(compromisso.fim.length == 0){
        erros.push("A data de termino é obrigatória.")
    }
   
    return erros;
}



botao.addEventListener('click', function(){
    var ul = document.querySelector("#mensagens-erro");
    ul.textContent="";
    var formulario = document.querySelector("#contato");
    
    var compromisso = {
        titulo: formulario.querySelector("#titulo").value,
        data: formulario.querySelector("#data").value,
        inicio: formulario.querySelector("#horaInicio").value,
        fim: formulario.querySelector("#horaFim")

    };
    
    var erros = [];
    erros = validaContato(compromisso);
    
    if(erros.length > 0){
    	event.preventDefault();
        ul.classList.add("pt-2");
        for(let i=0; i<erros.length; i++){
            var li = document.createElement("li");
            li.textContent=erros[i];
            ul.appendChild(li);
        }
    }
})