function trataMensagens(e){var t=$("#slides").find(".fotogrande");var n=t.length;if(e==n){e=0}var r=$(t[e]).attr("title");var i=$("#list-foto").find("h1").html();var s=$(t[e]).attr("data-fotoid");var o=$(".fotoid");var u=o.val(s);var a=$("#comentarios");$.ajax({type:"POST",url:"/fotolog/mensagem/mensagemporfoto",data:{idfoto:s},dataType:"json",before:function(){a.innerHTML=""},success:function(e,t,n){var r;a.html(r)},error:function(e,t,n){}})}