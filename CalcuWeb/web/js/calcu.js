			var $num1 = document.getElementById('num1');
        	var $num2 = document.getElementById('num2');
        	var $button = document.getElementById('calcula');
        	var $combo = document.getElementById('combo');
        	function calculando (e) {
        		// body...
        		var num1_valor = parseInt($num1.value);
        		var num2_valor = parseInt($num2.value);
        		var eleccion = $combo.value;
        		var total = 0;
        		if(eleccion ==1){
        			total = num1_valor + num2_valor;
        		}else{
        			if(eleccion == 2) {
        				total = num1_valor - num2_valor;
        			}else{
        				if(eleccion == 3) {
    						total = num1_valor * num2_valor;
        				}else{
        					if (eleccion == 4) {
        						total = num1_valor / num2_valor;
        					}else{
        						alert("Verifica los cambos");
        					}
        				}
        			}
        		}
        		if(eleccion != 0){
        			alert("El total es: " + total);
        		}	
        	}
        	$button.addEventListener('click', calculando);