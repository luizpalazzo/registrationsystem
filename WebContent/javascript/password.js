function validarSenha(){
	var senha1 = document.getElementById("senha1").value;
	var senha2 = document.getElementById("senha2").value;
	
	if(senha1 == senha2){
		return true;
	}else{
		alert("Senhas não conferem!");
		return false;
	}
}