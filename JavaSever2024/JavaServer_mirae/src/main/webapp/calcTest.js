function calcjs() {
	var n1 = parsInt(document.getElementById("n1").value);
	var n2 = parsInt(document.getElementById("n2").value);
	var op = document.getElementById("op").value;
	var ans = document.getElementById("ans");
	
	var result = 0;
	
	switch(op){
		case "+" : result = n1 + n2;
		break;
		case "-" : result = n1 - n2;
		break;
		case "*" : result = n1 * n2;
		break;
		case "/" : result = n1 / n2;
		break;
	}
	console.log(result)
	ans.value = result;
}