jQuery(document).ready(function(e){e(".enviarmensagem").click(function(){var t=e(".enviomsg").css("display");if(t=="none"){e(".enviomsg").css("display","block")}else{e(".enviomsg").css("display","none")}});e(".enviomsg").submit(function(t){var n=e(".enviomsg").serializeArray();var r=e(".enviomsg").attr("action");e(".message").hide();e(".ajaxerror").hide();e.ajax({url:r,type:"POST",data:n,dataType:"json",success:function(t,n,r){e(".message").html(t.mensagem);e(".message").show();e(".enviomsg")[0].reset();e(".enviomsg").css("display","none")},error:function(t,n,r){var i=0;var s='<ul class="errors" role="alert">';var o="";var u="</div>";while(i<t.responseJSON.length){o=o+"<li>"+t.responseJSON[i]+"</li>";i++}var a=s+o+u;e(".ajaxerror").html(a);e(".ajaxerror").show()}});t.preventDefault()})})