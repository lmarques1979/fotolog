function Left(str, n){
    if (n <= 0)
    	return "";
    else if (n > String(str).length)
    	return str;
    else
    	return String(str).substring(0,n);
}

function Right(str, n){
    if (n <= 0)
    	return "";
    else if (n > String(str).length)
    	return str;
    else {
    	var iLen = String(str).length;
    	return String(str).substring(iLen, iLen - n);
    }
}

function trataMensagens(index){
		 	
			$(".message").hide();
			$(".enviomsg" ).css("display", "none");
			
			var $imgs 	= $('#slides').find('.fotogrande');
		    var len 	= $imgs.length;
		    if (index == len){
		   	 index = 0;
		    }
		    
		    var total   = ' (Foto ' + (index+1) + ' de ' + $('.totalfotos').attr('data-totalfotos') + ')';
		    var legenda = $($imgs[index]).attr('data-legenda');
		    var titulo	= $('#list-foto').find('h1').html();
		    var fotoid  = $($imgs[index]).attr('data-fotoid');
		    var idcomentario = $(".fotoid");
		    var valor = idcomentario.val(fotoid);
		    
		    if(legenda!="null" && legenda!=""){ 
		    	//Insiro Legenda
			    $('.caption').html(legenda + total);
		    }else{
		    	$('.caption').html(total);
		    	
		    }
		    
		    
		    /*Chamar  a função ajax com retorno JSON para popular a div de mensagens*/
		    var $comentarios = $('#comentarios');
		    
		    $.ajax({
		    	type:"POST",
		    	url:"/galeria/mensagem/mensagemporfoto",
		    	data:{idfoto:fotoid},
		    	dataType: "json",
		    	before:function(){
		    		$comentarios.innerHTML="";
		    	},
			        success:function(data, textStatus, jqXHR)
			        {
			        	var htmlfinal="<div class='resultados'>";
			        	var i=0;
			        	while (i<data.mensagens.length) {
			        		var formattedDate = new Date(data.mensagens[i].dateCreated);
			        		var dataFinal = formattedDate.getDate() + '/' + (formattedDate.getMonth() + 1) + '/' + formattedDate.getFullYear();
			        		var mins = ('0'+formattedDate.getMinutes()).slice(-2);
			        		var horaFinal = formattedDate.getHours() + ':' + mins;
			        		var cabecalho = "<h1>Em " + dataFinal + " as " + horaFinal + " " + data.mensagens[i].remetente + " escreveu:</h1>";
			        		var conteudo  = "<p class='mensagem'>" + data.mensagens[i].mensagem + "</p><br>";
			        		var mensagem  = cabecalho + conteudo ;
			        		htmlfinal = htmlfinal + mensagem;
			        		i++;
				        }
			        	htmlfinal=htmlfinal + "</div>";
			        	$comentarios.html(htmlfinal);
				        
				        
			        },
			        error: function(jqXHR, textStatus, errorThrown)
		        	{
			        	
		        	}
		    });
}