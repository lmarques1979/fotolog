function trataMensagens(e){var t=$("#slides").find(".fotogrande");var n=t.length;if(e==n){e=0}var r=$(t[e]).attr("title");var i=$("#list-foto").find("h1").html();var s=$(t[e]).attr("data-fotoid");var o=$(".fotoid");var u=o.val(s);var a=$("#comentarios");$.ajax({type:"POST",url:"/fotolog/mensagem/mensagemporfoto",data:{idfoto:s},dataType:"json",before:function(){a.innerHTML=""},success:function(e,t,n){var r="<div class='resultados'>";var i=0;while(i<e.mensagens.length){var s=new Date(e.mensagens[i].dateCreated);var o=s.getDate()+"/"+(s.getMonth()+1)+"/"+s.getFullYear();var u=s.getHours()+":"+s.getMinutes();var f="<h1>Em "+o+" às "+u+" "+e.mensagens[i].remetente+" escreveu:</h1><br>";var l="<p class='mensagem'>"+e.mensagens[i].mensagem+"</p><br>";var c=f+l;r=r+c;i++}r=r+"</div>";a.html(r)},error:function(e,t,n){}})}