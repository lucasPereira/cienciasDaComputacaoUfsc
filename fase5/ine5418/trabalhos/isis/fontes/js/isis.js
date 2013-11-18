(function() {
	function inicializar() {
		document.getElementById("botaoSacar").onclick = function() {
			var requisicaoXml = new XMLHttpRequest();
			requisicaoXml.open("PUT", "/saque/" + calcularHash(), false);
			requisicaoXml.setRequestHeader("Content-Type", "application/json");
			requisicaoXml.send(JSON.stringify({valor: parseFloat(document.getElementById("campoValor").value)}))
			obterSaldo();
			document.getElementById("campoValor").value = "";
		};
		document.getElementById("botaoDepositar").onclick = function() {
			var requisicaoXml = new XMLHttpRequest();
			requisicaoXml.open("PUT", "/deposito/" + calcularHash(), false);
			requisicaoXml.setRequestHeader("Content-Type", "application/json");
			requisicaoXml.send(JSON.stringify({valor: parseFloat(document.getElementById("campoValor").value)}))
			obterSaldo();
			document.getElementById("campoValor").value = "";
		}
		document.getElementById("botaoCorrigir").onclick = function() {
			var requisicaoXml = new XMLHttpRequest();
			requisicaoXml.open("PUT", "/correcao/" + calcularHash(), false);
			requisicaoXml.setRequestHeader("Content-Type", "application/json");
			requisicaoXml.send(JSON.stringify({valor: parseFloat(document.getElementById("campoValor").value)}))
			obterSaldo();
			document.getElementById("campoValor").value = "";
		}
		document.getElementById("botaoAtualizarSaldo").onclick = function() {
			obterSaldo();
		}
	};
	
	function obterSaldo() {
		var requisicaoXml = new XMLHttpRequest();
		requisicaoXml.open("GET", "/saldo", false);
		requisicaoXml.send();
		document.getElementById("saldo").innerHTML = ("Saldo: " + JSON.parse(requisicaoXml.responseText).saldo);
	};
	
	function calcularHash() {
		var caracteres = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz";
		var tamanhoDoHash = 32;
		var hash = "h";
		for (var contador = 0; contador < tamanhoDoHash; contador++) {
			hash += caracteres[parseInt(Math.random() * caracteres.length)];
		}
		return hash;
	};
	
	window.onload = inicializar; 
} ());