let botao = document.querySelector("#bt-criar");



function validaContato(contato) {
   
    var erros = [];

    if(contato.nome.length < 5){
        erros.push ("O nome deve ter pelos menos 5 caracteres.");
    }
    if(contato.nome.length === 0){
        erros.push("O nome é obrigatório.")
    }
    if(contato.email.length < 7) {
        erros.push ("O email é obrigatório.");
    }

    if(contato.endereco.length < 8 ) {
        erros.push ("Escreva seu endereço completo");
    }

    if(contato.telefone.length < 8) {
        erros.push ("Escreva o telefone com pelomenos 10 caracteres");
    }
    return erros;
}

alert(botao)

botao.addEventListener('click', function(){
    var ul = document.querySelector("#mensagens-erro");
    ul.textContent="";
    var formulario = document.querySelector("#contato");
    
    var contato = {
        nome: formulario.querySelector("#nome").value,
        email: formulario.querySelector("#email").value,
        telefone: formulario.querySelector("#telefone").value,
        endereco: formulario.querySelector("#endereco").value
    };
    
    var erros = [];
    erros = validaContato(contato);
    
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